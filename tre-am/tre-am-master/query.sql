ALTER TABLE GUIA_PROCEDIMENTO 
ADD ID_GUIA_PROCEDIMENTO NUMBER;


CREATE SEQUENCE SEQ_GUIA_PROCEDIMENTO
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

UPDATE GUIA_PROCEDIMENTO SET ID_GUIA_PROCEDIMENTO = SEQ_GUIA_PROCEDIMENTO.nextval;

ALTER TABLE GUIA_PROCEDIMENTO
ADD CONSTRAINT GUIA_PROCEDIMENTO_PK PRIMARY KEY (ID_GUIA_PROCEDIMENTO);


--

ALTER TABLE BENEFICIARIO 
ADD ID_BENEFICIARIO NUMBER;


CREATE SEQUENCE SEQ_BENEFICIARIO
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

UPDATE BENEFICIARIO SET ID_BENEFICIARIO = SEQ_BENEFICIARIO.nextval;

ALTER TABLE BENEFICIARIO
ADD CONSTRAINT BENEFICIARIO_PK PRIMARY KEY (ID_BENEFICIARIO);


-- 11/12/19

CREATE TABLE DESPESA (
    COD_DESPESA NUMBER NOT NULL ENABLE,
    DATA_CADASTRO DATE default sysdate NOT NULL,
    OBSERVACAO VARCHAR2(255 BYTE) NOT NULL ENABLE,
    VALOR  FLOAT(126),
    NUM_GUIA NUMBER(10,0), 
	ANO_EXERCICIO CHAR(4 BYTE), 
	COD_TIP_GUIA NUMBER(10,0),
    CONSTRAINT "DESPESA_PK" PRIMARY KEY ( "COD_DESPESA" ),
    CONSTRAINT "FK_DESPESA_GUIA" FOREIGN KEY ("NUM_GUIA", "ANO_EXERCICIO", "COD_TIP_GUIA")
	  REFERENCES "ADMTREMAISSAUDE"."GUIA" ("NUM_GUIA", "ANO_EXERCICIO", "COD_TIP_GUIA")
);

CREATE TABLE ANEXO_DESPESA (
    COD_ANEXO_DESPESA NUMBER NOT NULL ENABLE,
    COD_DESPESA NUMBER,
    DOCUMENTO BLOB,
    NOME VARCHAR2(255 BYTE),
    TIPO VARCHAR2(20 BYTE),
    CONSTRAINT ANEXO_DESPESA_PK PRIMARY KEY (COD_ANEXO_DESPESA),
    CONSTRAINT FK_DESPESA  FOREIGN KEY (COD_DESPESA) REFERENCES DESPESA (COD_DESPESA)
);

 alter table GUIA add COD_DESPESA number constraint FK_GUIA_DESPESA references DESPESA(COD_DESPESA);
 
 CREATE SEQUENCE SEQ_DESPESA
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  CREATE SEQUENCE SEQ_DESPESA_ANEXO
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  
  
-- em anÃ¡lise 20/12/2019

/*
CREATE TABLE LOTE_IMPORTACAO (
    COD_LOTE_IMPORTACAO NUMBER NOT NULL ENABLE,
    TIPO_TRANSACAO VARCHAR2(100 BYTE),
    SEQUENCIAL_TRANSACAO VARCHAR2(100 BYTE),
    DATA_REGISTRO_TRANSACAO DATE,
    CNPJ_ORIGEM_PRESTADOR VARCHAR2(14 BYTE),
    REGISTRO_ANS_DESTINO VARCHAR2(50 BYTE),
    VERSAO_DESTINO VARCHAR2(50 BYTE),
    NUMERO_LOTE VARCHAR2(50 BYTE),
    HASH_EPILOGO VARCHAR2(255 BYTE),
    CONSTRAINT "LOTE_IMPORTACAO_PK" PRIMARY KEY ( "COD_LOTE_IMPORTACAO" )
);


CREATE TABLE LOTE_GUIA (
    COD_LOTE_GUIA NUMBER NOT NULL ENABLE,
    COD_LOTE_IMPORTACAO NUMBER NOT NULL ENABLE,
    NUM_GUIA NUMBER(10,0) NOT NULL,
    ANO_EXERCICIO CHAR(4 BYTE) NOT NULL,
    COD_TIP_GUIA NUMBER(10,0) NOT NULL,
    CONSTRAINT "LOTE_GUIA_PK" PRIMARY KEY ("COD_LOTE_GUIA"),
    CONSTRAINT "FK_LOTE" FOREIGN KEY ("COD_LOTE_IMPORTACAO")
	  REFERENCES "ADMTREMAISSAUDE"."LOTE_IMPORTACAO" ("COD_LOTE_IMPORTACAO"),
     CONSTRAINT "FK_LOTE_GUIA" FOREIGN KEY ("NUM_GUIA", "ANO_EXERCICIO", "COD_TIP_GUIA")
	  REFERENCES "ADMTREMAISSAUDE"."GUIA" ("NUM_GUIA", "ANO_EXERCICIO", "COD_TIP_GUIA")  
);


CREATE SEQUENCE SEQ_LOTE_IMPORTACAO
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  
CREATE SEQUENCE SEQ_LOTE_GUIA
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20; 
*/  
  
-- 26/12/2019

ALTER TABLE GUIA_PROCEDIMENTO_ODO 
ADD ID_GUIA_PROCEDIMENTO NUMBER;


CREATE SEQUENCE SEQ_GUIA_PROCEDIMENTO_ODO
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

UPDATE GUIA_PROCEDIMENTO_ODO SET ID_GUIA_PROCEDIMENTO = SEQ_GUIA_PROCEDIMENTO_ODO.nextval;

ALTER TABLE GUIA_PROCEDIMENTO_ODO
ADD CONSTRAINT GUIA_PROCEDIMENTO_UK UNIQUE  (ID_GUIA_PROCEDIMENTO);
  
  
  
  

/*
CREATE TABLE GUIA_IMPORTACAO (
    COD_GUIA_IMPORTACAO NUMBER NOT NULL ENABLE,
    COD_LOTE_IMPORTACAO NUMBER NOT NULL ENABLE,
    REGISTRO_ANS VARCHAR2(50 BYTE),
    NUMERO_GUIA_PRESTADOR VARCHAR2(20 BYTE),
    GUIA_PRINCIPAL VARCHAR2(20 BYTE),
    NUMERO_GUIA_OPERADORA VARCHAR2(20 BYTE),
    DATA_AUTORIZACAO DATE,
    NUMERO_CARTEIRA VARCHAR2(20 BYTE),
    ATENDIMENTO_RN VARCHAR2(5 BYTE),
    NOME_BENEFICIARIO VARCHAR2(70 BYTE),
    CNPJ_CONTRATADO VARCHAR2(14 BYTE),
    NOME_CONTRATADO VARCHAR2(70 BYTE),
    NOME_PROFISSIONAL_SOLICITANTE VARCHAR2(70 BYTE),
    CONSELHO_PROFISSIONAL_SOLICITANTE VARCHAR2(20 BYTE),
    NUM_CONSELHO_PROFISSIONAL_SOLICITANTE VARCHAR2(20 BYTE),
    UF_SOLICITANTE VARCHAR2(2 BYTE),
    CBOS_SOLICITANTE VARCHAR2(20 BYTE),
    DATA_SOLICITACAO DATE,
    CARATER_ATEND_SOLICITACAO VARCHAR2(10 BYTE),
    CNPJ_CONTRATADO_EXECUTANTE VARCHAR2(14 BYTE),
    NOME_CONTRATADO_EXECUTANTE VARCHAR2(70 BYTE),
    CNES_EXECUTANTE VARCHAR2(7 BYTE),
    TIPO_ATENDIMENTO VARCHAR2,
    INDICACAO_ATENDIMENTO VARCHAR2,
    TIPO_CONSULTA_ATENDIMENTO VARCHAR2,
    DATA_EXECUCAO

    CONSTRAINT "GUIA_IMPORTACAO_PK" PRIMARY KEY ( "COD_GUIA_IMPORTACAO" ),
    CONSTRAINT "FK_LOTE_IMPORTACAO" FOREIGN KEY ("COD_LOTE_IMPORTACAO")
	  REFERENCES "ADMTREMAISSAUDE"."LOTE_IMPORTACAO" ("COD_LOTE_IMPORTACAO")
);
*/



create view AUTENTICACAO_CREDENCIADA as
select cre_aut.cod_credenciado, senha_md5 senha, i.email usuario, i.nom_instituicao,
case  
when cre_aut.bloqueado = 1 then '1' 
when i.email is null then '1'
else '0' end  BLOQUEADO
from credenciado_autorizado cre_aut
inner join credenciado cre on cre.cod_credenciado = cre_aut.cod_credenciado
inner join instituicao i on i.cod_instituicao = cre.cod_instituicao
order by cre_aut.cod_credenciado desc;


CREATE TABLE DOMINIO (
    COD_DOMINIO NUMBER NOT NULL ENABLE,
    DESCRICAO VARCHAR2(255),
    VALOR   VARCHAR2(255),
    SITUACAO  NUMBER, 
	DOMINIO VARCHAR2(255),
    CONSTRAINT "DOMINIO_PK" PRIMARY KEY ( "COD_DOMINIO" )
);

CREATE SEQUENCE SEQ_DOMINIO
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  
 --###################### UsuÃ¡rio odontologico
 INSERT INTO "ADMTREMAISSAUDE"."CREDENCIADO_AUTORIZADO" (COD_CREDENCIADO, SENHA_MD5, COD_CREDENCIADO_LOGIN, SENHA_MD5_LOGIN, BLOQUEADO, DAT_ULT_ATUAL, PERFIL) VALUES ('740', '7110eda4d09e62aa5e4a390b0a572acd2c220', '740', 'C4CA4238A0B923820DCC509A6F75849B', '0', TO_DATE('2019-08-07 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'ADM')

-- ######## Adicionado os Valores DOMINIO
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('1', 'PROCEDIMENTO_DESPESA', '40306445', '1', 'PROCEDIMENTO_DESPESA');

--TIPOS GUIAS MEDICAS
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('2', '1 - GUIA MÃ‰DICA - CLÃ�NICA/LABORATORIAL', '1', '1', 'GUIA_MEDICA');
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('3', '2 - GUIA MÃ‰DICA - CIRÃšRGICA/HOSPITALAR', '2', '1', 'GUIA_MEDICA');
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('4', '15 - GUIA MÃ‰DICA - DESPESAS HOME CARE', '15', '1', 'GUIA_MEDICA');
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('5', '16 - GUIA MÃ‰DICA - DESPESAS OPMEC', '16', '1', 'GUIA_MEDICA');

--TIPOS GUIAS ODONTOLOGICAS
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('6', '3 - GUIA ODONTOLÃ“GICA - PADRÃƒO', '3', '1', 'GUIA_ODONTOLOGICA');
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('7', '6 - REEMBOLSO ODONT. - PADRÃƒO', '6', '1', 'GUIA_ODONTOLOGICA');
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('8', '14 - REEMBOLSO ODONT. - IMPLANTE', '14', '1', 'GUIA_ODONTOLOGICA');
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('9', '9 - GUIA ODONTOLÃ“GICA - EXAMES PERIÃ“DICOS', '9', '1', 'GUIA_ODONTOLOGICA');
INSERT INTO "ADMTREMAISSAUDE"."DOMINIO" (COD_DOMINIO, DESCRICAO, VALOR, SITUACAO, DOMINIO) VALUES ('10', '7 - GUIA ODONTOLÃ“GICA - IMPLANTE', '7', '1', 'GUIA_ODONTOLOGICA');
   
   
CREATE VIEW FAIXA_ETARIA_MENSALIDADE
AS select tp_faixa_etaria, valor_desc,
decode(tp_faixa_etaria , 0, 0, 1,19, 2,24, 3,29, 4,34, 5,39, 6,44, 7,49, 8,54, 9,59) inicio, 
decode(tp_faixa_etaria , 0, 18, 1,23, 2,28, 3,33, 4,38, 5,43, 6,48, 7,53, 8,58, 9,200) fim
from srh2.faixa_desconto where tp_faixa_etaria between 0 and 9;
						

CREATE OR REPLACE FORCE VIEW "ADMTREMAISSAUDE"."RELATORIO_MENSALIDADE_MENSAL" ("MES_ANO", "TITULAR", "FILHO(A)", "CÃ”NJUGE", "MÃƒE - ECONÃ”MICO", "COMPANHEIRO(A)", "PAI - ECONÃ”MICO", "MENOR SOB GUARDA", "ENTEADO(A)") AS 
  select "MES_ANO","TITULAR","FILHO(A)","CÃ”NJUGE","MÃƒE - ECONÃ”MICO","COMPANHEIRO(A)","PAI - ECONÃ”MICO","MENOR SOB GUARDA","ENTEADO(A)" from (
with mensalidade as (
select b.mat_servidor,fl.mes_ano_folha mes_ano,
(select valor_desc from faixa_etaria_mensalidade where (trunc((months_between(sysdate, to_date(to_char(b.dat_nasc, 'DD/MM/YYYY'),'dd/mm/yy')))/12)) between inicio and fim) valor,
nvl(t.nom_tipo_depend , 'TITULAR') tipo_dependente
from beneficiario b
left join tipo_dependente t on t.cod_tipo_depend = b.cod_tipo_depend
inner join folha.FL_SERV_TOT_MES fl on fl.mat_servidor = b.mat_servidor
where  fl.COD_RUBRICA = '6190.000'
) 
select tipo_dependente,mes_ano, sum(valor) valor 
from mensalidade
group by tipo_dependente, mes_ano
order by mes_ano) 
pivot 
(
sum(valor) for tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);
							
CREATE OR REPLACE FORCE VIEW "ADMTREMAISSAUDE"."RELATORIO_MENSALIDADE_ANUAL" ("ANO", "TITULAR", "FILHO(A)", "CÃ”NJUGE", "MÃƒE - ECONÃ”MICO", "COMPANHEIRO(A)", "PAI - ECONÃ”MICO", "MENOR SOB GUARDA", "ENTEADO(A)") AS 
  select "ANO","TITULAR","FILHO(A)","CÃ”NJUGE","MÃƒE - ECONÃ”MICO","COMPANHEIRO(A)","PAI - ECONÃ”MICO","MENOR SOB GUARDA","ENTEADO(A)" from (
with mensalidade as (
select b.mat_servidor,substr(fl.mes_ano_folha,3) ano,
(select valor_desc from faixa_etaria_mensalidade where (trunc((months_between(sysdate, to_date(to_char(b.dat_nasc, 'DD/MM/YYYY'),'dd/mm/yy')))/12)) between inicio and fim) valor,
nvl(t.nom_tipo_depend , 'TITULAR') tipo_dependente
from beneficiario b
left join tipo_dependente t on t.cod_tipo_depend = b.cod_tipo_depend
inner join folha.FL_SERV_TOT_MES fl on fl.mat_servidor = b.mat_servidor
where  fl.COD_RUBRICA = '6190.000'
) 
select tipo_dependente,ano, sum(valor) valor 
from mensalidade
group by tipo_dependente, ano
order by ano) 
pivot 
(
sum(valor) for tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);
							
							
							
							
							
							

CREATE VIEW RELATORIO_BENEFICIARIO_ANUAL
AS select * from (
with rel1 as (
select nvl( cod_depend, mat_servidor),mat_servidor, cod_depend , extract( YEAR from dat_emissao) dat_emissao
,
nvl((select  t_.nom_tipo_depend from beneficiario b_
inner join tipo_dependente t_ on t_.cod_tipo_depend = b_.cod_tipo_depend
where b_.mat_servidor = g.mat_servidor and b_.cod_depend = g.cod_depend
group by  t_.nom_tipo_depend), 'TITULAR') NOME_TIPO_DEPENDENTE
from guia g) 
    select NOME_TIPO_DEPENDENTE,dat_emissao, count(NOME_TIPO_DEPENDENTE) total from rel1
    group by NOME_TIPO_DEPENDENTE,dat_emissao
    order by count(NOME_TIPO_DEPENDENTE) desc
) 
pivot
(
sum(total) for nome_tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);
	
	CREATE VIEW RELATORIO_BENEFICIARIO_MENSAL
AS select * from (
with rel1 as (
select nvl( cod_depend, mat_servidor),mat_servidor, cod_depend , to_char(dat_emissao,'YYYY/MM') dat_emissao
,
nvl((select  t_.nom_tipo_depend from beneficiario b_
inner join tipo_dependente t_ on t_.cod_tipo_depend = b_.cod_tipo_depend
where b_.mat_servidor = g.mat_servidor and b_.cod_depend = g.cod_depend
group by  t_.nom_tipo_depend), 'TITULAR') NOME_TIPO_DEPENDENTE
from guia g) 
    select NOME_TIPO_DEPENDENTE,dat_emissao, count(NOME_TIPO_DEPENDENTE) total from rel1
    group by NOME_TIPO_DEPENDENTE,dat_emissao
    order by count(NOME_TIPO_DEPENDENTE) desc
) 
pivot
(
sum(total) for nome_tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);
	
	
  CREATE OR REPLACE FORCE VIEW "ADMTREMAISSAUDE"."RELATORIO_COPARTICIPAC_ANUAL" ("ANO", "TITULAR", "FILHO(A)", "CÃ”NJUGE", "MÃƒE - ECONÃ”MICO", "COMPANHEIRO(A)", "PAI - ECONÃ”MICO", "MENOR SOB GUARDA", "ENTEADO(A)") AS 
  select "ANO","TITULAR","FILHO(A)","CÃ”NJUGE","MÃƒE - ECONÃ”MICO","COMPANHEIRO(A)","PAI - ECONÃ”MICO","MENOR SOB GUARDA","ENTEADO(A)" from (
with mensalidade as (
select b.mat_servidor,substr(fl.mes_ano_folha,3) ano,
(select valor_desc from faixa_etaria_mensalidade where (trunc((months_between(sysdate, to_date(to_char(b.dat_nasc, 'DD/MM/YYYY'),'dd/mm/yy')))/12)) between inicio and fim) valor,
nvl(t.nom_tipo_depend , 'TITULAR') tipo_dependente
from beneficiario b
left join tipo_dependente t on t.cod_tipo_depend = b.cod_tipo_depend
inner join folha.FL_SERV_TOT_MES fl on fl.mat_servidor = b.mat_servidor
where  fl.COD_RUBRICA = '6191.000'
) 
select tipo_dependente,ano, sum(valor) valor 
from mensalidade
group by tipo_dependente, ano
order by ano) 
pivot 
(
sum(valor) for tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);

 
 
  CREATE OR REPLACE FORCE VIEW "ADMTREMAISSAUDE"."RELATORIO_COPARTICIPAC_MENSAL" ("MES_ANO", "TITULAR", "FILHO(A)", "CÃ”NJUGE", "MÃƒE - ECONÃ”MICO", "COMPANHEIRO(A)", "PAI - ECONÃ”MICO", "MENOR SOB GUARDA", "ENTEADO(A)") AS 
  select "MES_ANO","TITULAR","FILHO(A)","CÃ”NJUGE","MÃƒE - ECONÃ”MICO","COMPANHEIRO(A)","PAI - ECONÃ”MICO","MENOR SOB GUARDA","ENTEADO(A)" from (
with mensalidade as (
select b.mat_servidor,fl.mes_ano_folha mes_ano,
(select valor_desc from faixa_etaria_mensalidade where (trunc((months_between(sysdate, to_date(to_char(b.dat_nasc, 'DD/MM/YYYY'),'dd/mm/yy')))/12)) between inicio and fim) valor,
nvl(t.nom_tipo_depend , 'TITULAR') tipo_dependente
from beneficiario b
left join tipo_dependente t on t.cod_tipo_depend = b.cod_tipo_depend
inner join folha.FL_SERV_TOT_MES fl on fl.mat_servidor = b.mat_servidor
where  fl.COD_RUBRICA = '6191.000'
) 
select tipo_dependente,mes_ano, sum(valor) valor 
from mensalidade
group by tipo_dependente, mes_ano
order by mes_ano) 
pivot 
(
sum(valor) for tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);

 
  CREATE OR REPLACE FORCE VIEW "ADMTREMAISSAUDE"."RELATORIO_DESPESAS_ANUAL" ("ANO", "TITULAR", "FILHO(A)", "CÃ”NJUGE", "MÃƒE - ECONÃ”MICO", "COMPANHEIRO(A)", "PAI - ECONÃ”MICO", "MENOR SOB GUARDA", "ENTEADO(A)") AS 
  select "ANO","TITULAR","FILHO(A)","CÃ”NJUGE","MÃƒE - ECONÃ”MICO","COMPANHEIRO(A)","PAI - ECONÃ”MICO","MENOR SOB GUARDA","ENTEADO(A)" from (
with mensalidade as (
select b.mat_servidor,substr(fl.mes_ano_folha,3) ano,
(select valor_desc from faixa_etaria_mensalidade where (trunc((months_between(sysdate, to_date(to_char(b.dat_nasc, 'DD/MM/YYYY'),'dd/mm/yy')))/12)) between inicio and fim) valor,
nvl(t.nom_tipo_depend , 'TITULAR') tipo_dependente
from beneficiario b
left join tipo_dependente t on t.cod_tipo_depend = b.cod_tipo_depend
inner join folha.FL_SERV_TOT_MES fl on fl.mat_servidor = b.mat_servidor
where  fl.COD_RUBRICA in ('6190.000', '6191.000')
) 
select tipo_dependente,ano, sum(valor) valor 
from mensalidade
group by tipo_dependente, ano
order by ano) 
pivot 
(
sum(valor) for tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);

 
 
  CREATE OR REPLACE FORCE VIEW "ADMTREMAISSAUDE"."RELATORIO_DESPESAS_MENSAL" ("MES_ANO", "TITULAR", "FILHO(A)", "CÃ”NJUGE", "MÃƒE - ECONÃ”MICO", "COMPANHEIRO(A)", "PAI - ECONÃ”MICO", "MENOR SOB GUARDA", "ENTEADO(A)") AS 
  select "MES_ANO","TITULAR","FILHO(A)","CÃ”NJUGE","MÃƒE - ECONÃ”MICO","COMPANHEIRO(A)","PAI - ECONÃ”MICO","MENOR SOB GUARDA","ENTEADO(A)" from (
with mensalidade as (
select b.mat_servidor,fl.mes_ano_folha mes_ano,
(select valor_desc from faixa_etaria_mensalidade where (trunc((months_between(sysdate, to_date(to_char(b.dat_nasc, 'DD/MM/YYYY'),'dd/mm/yy')))/12)) between inicio and fim) valor,
nvl(t.nom_tipo_depend , 'TITULAR') tipo_dependente
from beneficiario b
left join tipo_dependente t on t.cod_tipo_depend = b.cod_tipo_depend
inner join folha.FL_SERV_TOT_MES fl on fl.mat_servidor = b.mat_servidor
where  fl.COD_RUBRICA in ( '6190.000', '6191.000')
) 
select tipo_dependente,mes_ano, sum(valor) valor 
from mensalidade
group by tipo_dependente, mes_ano
order by mes_ano) 
pivot 
(
sum(valor) for tipo_dependente in (
'TITULAR' as TITULAR,
'FILHO(A)' as "FILHO(A)",
'CÃ”NJUGE' as "CÃ”NJUGE",
'MÃƒE - ECONÃ”MICO' as "MÃƒE - ECONÃ”MICO",
'COMPANHEIRO(A)' as "COMPANHEIRO(A)",
'PAI - ECONÃ”MICO' as "PAI - ECONÃ”MICO",
'MENOR SOB GUARDA' as "MENOR SOB GUARDA",
'ENTEADO(A)' as "ENTEADO(A)")
);


--Procedimento para o anexo
 INSERT INTO "ADMTREMAISSAUDE"."PROCEDIMENTO" (COD_PROCEDIMENTO, COD_TABELA, NOM_PROCEDIMENTO, VALOR_PROCEDIMENTO, COD_ESPECIALIDADE, REQUER_ESPECIALIDADE, REQUER_AUTORIZACAO, QTD_AUXILIAR, DETALHA_PROCED, PROCEDIMENTO_ATIVO, IND_EXCECAO, TRATAMENTO_SERIADO, CONSULTA) VALUES ('99000001', '27', 'Pacote/materiais/medicamentos ou diversos.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')
