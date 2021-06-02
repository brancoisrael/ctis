WITH tb_ano_tp_dependente AS (
    SELECT
        EXTRACT(YEAR FROM dat_emissao) dat_emissao,
        nvl((
            SELECT
                t_.nom_tipo_depend
            FROM
                beneficiario      b_
                INNER JOIN tipo_dependente   t_ ON t_.cod_tipo_depend = b_.cod_tipo_depend
            WHERE
                b_.mat_servidor = g.mat_servidor
                AND b_.cod_depend = g.cod_depend
            GROUP BY
                t_.nom_tipo_depend
        ), 'TITULAR') nome_tipo_dependente
    FROM
        guia g
), total_ano_tp_depend AS (
    SELECT
        nome_tipo_dependente,
        dat_emissao,
        COUNT(nome_tipo_dependente) total
    FROM
        tb_ano_tp_dependente
    GROUP BY
        nome_tipo_dependente,
        dat_emissao
    ORDER BY
        dat_emissao DESC
),
 tb_ano_depend_sintetico as (
SELECT
    TO_CHAR("DAT_EMISSAO") "DAT_EMISSAO",
    nvl("TITULAR", 0) "TITULAR",
    nvl("FILHO(A)", 0) "FILHO(A)",
    nvl("CÔNJUGE", 0) "CÔNJUGE",
    nvl("MÃE - ECONÔMICO", 0) "MÃE - ECONÔMICO",
    nvl("COMPANHEIRO(A)", 0) "COMPANHEIRO(A)",
    nvl("PAI - ECONÔMICO", 0) "PAI - ECONÔMICO",
    nvl("MENOR SOB GUARDA",0) "MENOR SOB GUARDA",
    nvl("ENTEADO(A)", 0) "ENTEADO(A)",
    ( nvl("TITULAR", 0) + nvl("FILHO(A)", 0) + nvl("CÔNJUGE", 0) + nvl("MÃE - ECONÔMICO", 0) + nvl("COMPANHEIRO(A)", 0) + nvl("PAI - ECONÔMICO"
    , 0) + nvl("MENOR SOB GUARDA", 0) + nvl("ENTEADO(A)", 0) ) AS total
FROM
    total_ano_tp_depend PIVOT (
        SUM ( total )
        FOR nome_tipo_dependente
        IN ( 'TITULAR' AS titular, 'FILHO(A)' AS "FILHO(A)", 'CÔNJUGE' AS "CÔNJUGE", 'MÃE - ECONÔMICO' AS "MÃE - ECONÔMICO", 'COMPANHEIRO(A)'
        AS "COMPANHEIRO(A)", 'PAI - ECONÔMICO' AS "PAI - ECONÔMICO", 'MENOR SOB GUARDA' AS "MENOR SOB GUARDA", 'ENTEADO(A)' AS "ENTEADO(A)"
        )
    )
),
 tb_media_por_ano_depend as (
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
    FROM tb_ano_depend_sintetico group by 'MÉDIA*'
 )

select * from tb_ano_depend_sintetico
UNION ALL
select * from tb_media_por_ano_depend