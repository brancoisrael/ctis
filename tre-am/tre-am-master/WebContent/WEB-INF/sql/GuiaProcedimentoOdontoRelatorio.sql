/**
	Consulta analítica dos procedimentos da guia 
**/
SELECT distinct
    c.nom_credenciado credenciado
    ,g.num_guia || '/' || g.ano_exercicio numero_guia
    ,g.dat_emissao data_emissao
    ,c.dat_validade_contrato validade
    ,g.funcao
    ,p2.nom_procedimento nome_procedimento
    ,null via
    ,null video
    ,gp.qtde quantidade
    ,gp.VALOR_PROCEDIMENTO valor
    ,gp.VALOR_TOTAL valor_total 
    ,(select b2.mat_servidor || ' - ' || b2.nome from beneficiario b2 where b2.mat_servidor = g.mat_servidor and b2.cod_depend is null) titular
    ,case when g.cod_depend is not null then
    (select  nome from beneficiario b3 where b3.mat_servidor = g.mat_servidor and g.cod_depend = b3.cod_depend)
     else
    (select b2.mat_servidor || ' - ' || b2.nome from beneficiario b2 where b2.mat_servidor = g.mat_servidor and b2.cod_depend is null) end paciente
    ,s.nom_especialidade  especialidade
FROM
    guia_procedimento_odo gp
    INNER JOIN guia g ON ( gp.ano_exercicio = g.ano_exercicio
                           AND gp.cod_tip_guia = g.cod_tip_guia
                           AND gp.num_guia = g.num_guia )
    INNER JOIN situacao s ON s.cod_situacao = g.cod_situacao
    INNER JOIN procedimento_odo p2 ON p2.cod_procedimento =gp.cod_procedimento and p2.cod_tabela=gp.cod_tabela 
    INNER JOIN credenciado c ON g.cod_credenciado = c.cod_credenciado
    INNER JOIN beneficiario b ON b.mat_servidor = g.mat_servidor
    LEFT  JOIN especialidade s on s.cod_especialidade = g.cod_especialidade
WHERE 1=1 
--[#condicoes#]
ORDER BY p2.nom_procedimento