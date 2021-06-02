WITH rel1 AS (
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
)
SELECT
    dat_emissao,
    COUNT(nome_tipo_dependente) total
FROM
    rel1
GROUP BY
    nome_tipo_dependente,
    dat_emissao
ORDER BY
    dat_emissao asc