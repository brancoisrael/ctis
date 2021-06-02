/**
	Consulta sintética das guias e o valor calculado 
**/
SELECT
    g.num_guia,
    g.ano_exercicio,
    g.cod_tip_guia,
    s.cod_situacao,
    s.nom_situacao,    
    g.dat_emissao,
    sum(gp.VALOR_TOTAL),
    case when g.cod_depend is null then 'Titular' else 'Dependente' end
FROM
    guia_procedimento_odo gp
    INNER JOIN guia g ON ( gp.ano_exercicio = g.ano_exercicio
                           AND gp.cod_tip_guia = g.cod_tip_guia
                           AND gp.num_guia = g.num_guia )
    INNER JOIN situacao s ON s.cod_situacao = g.cod_situacao
    INNER JOIN procedimento_odo p2 ON p2.cod_procedimento =gp.cod_procedimento and p2.cod_tabela=gp.cod_tabela
WHERE 1=1                                    
--[#condicoes#]
GROUP BY g.num_guia, g.ano_exercicio, g.cod_tip_guia, s.cod_situacao, s.nom_situacao, g.dat_emissao, g.cod_depend
ORDER BY g.dat_emissao DESC, g.num_guia DESC, g.ano_exercicio DESC  