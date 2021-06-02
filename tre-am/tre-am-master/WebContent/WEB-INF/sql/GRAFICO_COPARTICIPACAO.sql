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
)

select * from tb_valor_mens_por_tp_depend