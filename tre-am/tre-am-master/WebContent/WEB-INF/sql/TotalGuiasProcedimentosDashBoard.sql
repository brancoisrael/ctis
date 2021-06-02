/**
	Consulta total de guias
**/
SELECT count(total) from(
SELECT
    count(*) as total
FROM
    guia_procedimento gp
    INNER JOIN guia g ON ( gp.ano_exercicio = g.ano_exercicio
                           AND gp.cod_tip_guia = g.cod_tip_guia
                           AND gp.num_guia = g.num_guia )
    INNER JOIN situacao s ON s.cod_situacao = g.cod_situacao
    INNER JOIN procedimento p2 ON p2.cod_procedimento =gp.cod_procedimento and p2.cod_tabela=gp.cod_tabela
WHERE 1=1                                    
--[#condicoes#]
GROUP BY g.num_guia, g.ano_exercicio, g.cod_tip_guia, s.cod_situacao, s.nom_situacao, g.dat_emissao
  )