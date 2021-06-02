/**
	Consulta sintética das guias e o valor calculado 
**/
SELECT
    p2.cod_procedimento,
    p2.cod_tabela,
    p2.nom_procedimento
FROM
    guia_procedimento_odo gp
    INNER JOIN guia g ON (gp.ano_exercicio = g.ano_exercicio
                           AND gp.cod_tip_guia = g.cod_tip_guia
                           AND gp.num_guia = g.num_guia )
    INNER JOIN procedimento_odo p2 ON p2.cod_procedimento =gp.cod_procedimento and p2.cod_tabela=gp.cod_tabela
WHERE
    1 = 1
--[#condicoes#]
