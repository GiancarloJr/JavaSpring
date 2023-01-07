INSERT INTO PESSOAS (PES_NAME,PES_CPF,PES_EMAIL,PES_CEP,PES_LOGRADOURO,PES_COMPLEMENTO,PES_BAIRRO,PES_UF) VALUES ('Giancarlo', '15827288888', 'giancarlo@hotmail.com',75909796,'Rua das casas','Em frente a praça','Interlagos', 'GO');
INSERT INTO CONTATOS (CON_NAME,CON_TELEFONE,CON_CELULAR,PESSOA_ID) VALUES ('Silvia',12345678,123456789,1);
INSERT INTO CONTATOS (CON_NAME,CON_TELEFONE,CON_CELULAR,PESSOA_ID) VALUES ('Marcos',12345678,123456789,1);
--

-- SCRIPT PARA OUTROS BANCOS OU MIGRATION
-- CREATE TABLE IF NOT EXISTS PESSOAS (
--                                        PES_ID SERIAL PRIMARY KEY NOT NULL,
--                                        PES_NAME VARCHAR(100) UNIQUE NOT NULL,
--                                        PES_EMAIL VARCHAR(100) UNIQUE NOT NULL,
--                                        PES_CPF VARCHAR(20) UNIQUE NOT NULL,
--                                        PES_CEP INT NOT NULL,
--                                        PES_LOGRADOURO VARCHAR(100) NOT NULL,
--                                        PES_COMPLEMENTO VARCHAR(100) NOT NULL,
--                                        PES_BAIRRO VARCHAR(100) NOT NULL,
--                                        PES_UF VARCHAR(20) NOT NULL
-- );
-- CREATE TABLE IF NOT EXISTS CONTATOS(
--                                        CON_ID SERIAL PRIMARY KEY NOT NULL,
--                                        CON_NAME VARCHAR(150) NOT NULL,
--                                        CON_TELEFONE INT NOT NULL,
--                                        CON_CELULAR INT NOT NULL,
--                                        PESSOA_ID INT NOT NULL,
--                                        FOREIGN KEY (PESSOA_ID) REFERENCES PESSOAS(PES_ID)
-- );
