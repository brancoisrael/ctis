WITH mensalidade AS (
    SELECT
        substr(fl.mes_ano_folha,0, 2)  || '/' ||  substr(fl.mes_ano_folha, 3) ano,
        (
            SELECT
                valor_desc
            FROM
                faixa_etaria_mensalidade
            WHERE
                ( trunc((months_between(SYSDATE, TO_DATE(TO_CHAR(b.dat_nasc, 'DD/MM/YYYY'), 'dd/mm/yy'))) / 12) ) BETWEEN inicio AND
                fim
        ) valor,
        nvl(t.nom_tipo_depend, 'TITULAR') tipo_dependente
    FROM
        beneficiario            b
        LEFT JOIN tipo_dependente         t ON t.cod_tipo_depend = b.cod_tipo_depend
        INNER JOIN folha.fl_serv_tot_mes   fl ON fl.mat_servidor = b.mat_servidor
    WHERE
        fl.cod_rubrica = '6191.000'
), tb_valor_mens_por_tp_depend AS (
    SELECT
        tipo_dependente,
        ano,
        SUM(valor) valor
    FROM
        mensalidade
    GROUP BY
        tipo_dependente,
        ano
    ORDER BY
        ano
), tb_valor_mens_sintetico AS (
    SELECT
        "ANO",
        "TITULAR",
        "FILHO(A)",
        "CÔNJUGE",
        "MÃE - ECONÔMICO",
        "COMPANHEIRO(A)",
        "PAI - ECONÔMICO",
        "MENOR SOB GUARDA",
        "ENTEADO(A)",
        ( nvl("TITULAR", 0) + nvl("FILHO(A)", 0) + nvl("CÔNJUGE", 0) + nvl("MÃE - ECONÔMICO", 0) + nvl("COMPANHEIRO(A)", 0) + nvl("PAI - ECONÔMICO"
        , 0) + nvl("MENOR SOB GUARDA", 0) + nvl("ENTEADO(A)", 0) ) AS total
    FROM
        tb_valor_mens_por_tp_depend PIVOT (
            SUM ( valor )
            FOR tipo_dependente
            IN ( 'TITULAR' AS titular, 'FILHO(A)' AS "FILHO(A)", 'CÔNJUGE' AS "CÔNJUGE", 'MÃE - ECONÔMICO' AS "MÃE - ECONÔMICO", 'COMPANHEIRO(A)'
            AS "COMPANHEIRO(A)", 'PAI - ECONÔMICO' AS "PAI - ECONÔMICO", 'MENOR SOB GUARDA' AS "MENOR SOB GUARDA", 'ENTEADO(A)' AS
            "ENTEADO(A)" )

        )
),
 tb_media_valor_mens as (
 SELECT
'MÉDIA*' "MÉDIA",
    round(AVG(nvl("TITULAR", 0)), 2) "TITULAR",
    round(AVG(nvl("FILHO(A)", 0)), 2) "FILHO(A)",
    round(AVG(nvl("CÔNJUGE", 0)), 2) "CÔNJUGE",
    round(AVG(nvl("MÃE - ECONÔMICO", 0)), 2) "MÃE - ECONÔMICO",
    round(AVG(nvl("COMPANHEIRO(A)", 0)), 2) "COMPANHEIRO(A)",
    round(AVG(nvl("PAI - ECONÔMICO", 0)), 2) "PAI - ECONÔMICO",
    round(AVG(nvl("MENOR SOB GUARDA", 0)), 2) "MENOR SOB GUARDA",
    round(AVG(nvl("ENTEADO(A)", 0)), 2) "ENTEADO(A)",
    round(AVG(nvl("TITULAR", 0) + nvl("FILHO(A)", 0) + nvl("CÔNJUGE", 0) + nvl("MÃE - ECONÔMICO", 0) + nvl("COMPANHEIRO(A)", 0) +
    nvl("PAI - ECONÔMICO", 0) + nvl("MENOR SOB GUARDA", 0) + nvl("ENTEADO(A)", 0)), 2) AS total
    FROM tb_valor_mens_sintetico group by 'MÉDIA*'
 ),

resultado_final as (
select * from tb_valor_mens_sintetico
UNION ALL
select * from tb_media_valor_mens)
Select * from resultado_final order by ano desc