-- =================================================================================
-- 1. POPULANDO A TABELA DE HEMOCENTROS (tb_hemocentro)
-- =================================================================================
INSERT INTO tb_hemocentro (id, nome, descricao) VALUES (1, 'Hemocentro Central', 'Unidade principal de captação de doadores da capital.');
INSERT INTO tb_hemocentro (id, nome, descricao) VALUES (2, 'Hemocentro Regional Sul', 'Unidade de triagem e armazenamento da zona sul.');

-- =================================================================================
-- 2. POPULANDO A TABELA DE PESSOAS (tb_pessoa)
-- =================================================================================
INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES (1, 'Carlos Silva', '111.222.333-44', 'carlos.silva@email.com');
INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES (2, 'Ana Costa', '555.666.777-88', 'ana.costa@email.com');
INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES (3, 'Mariana Souza', '999.888.777-66', 'mariana.souza@email.com');

-- =================================================================================
-- 3. POPULANDO A TABELA DE USUÁRIOS (tb_usuario)
-- Depende de: tb_pessoa e tb_hemocentro
-- Enums válidos: 'USUARIO', 'FUNCIONARIO', 'GERENTE'
-- =================================================================================
INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id, hemocentro_id) VALUES (1, 'carlos_gerente', '123', 'GERENTE', 1, 1);
INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id, hemocentro_id) VALUES (2, 'ana_funcionario', '123', 'FUNCIONARIO', 2, 1);
INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id, hemocentro_id) VALUES (3, 'mariana_usuario', '123', 'USUARIO', 3, 2);

-- =================================================================================
-- 4. POPULANDO A TABELA DE EXAMES BASE (tb_exame)
-- =================================================================================
INSERT INTO tb_exame (id, nome, descricao) VALUES (1, 'Sorologia Sífilis', 'Teste de triagem sorológica (como VDRL) para detecção de anticorpos contra o Treponema pallidum.');
INSERT INTO tb_exame (id, nome, descricao) VALUES (2, 'Sorologia HIV', 'Triagem de anticorpos contra os vírus HIV 1 e 2.');
INSERT INTO tb_exame (id, nome, descricao) VALUES (3, 'Sorologia Hepatite B', 'Detecção do antígeno HBsAg para Hepatite B.');

-- =================================================================================
-- 5. POPULANDO A TABELA DE COLETAS (tb_coleta)
-- Depende de: tb_hemocentro e tb_pessoa
-- Enums válidos: 'A_POSITIVO', 'A_NEGATIVO', 'B_POSITIVO', 'B_NEGATIVO', etc.
-- =================================================================================
INSERT INTO tb_coleta (id, data_coleta, data_validade, tipo_sanguineo, hemocentro_id, pessoa_id) VALUES (1, '2026-06-01', '2026-07-15', 'O_POSITIVO', 1, 1);
INSERT INTO tb_coleta (id, data_coleta, data_validade, tipo_sanguineo, hemocentro_id, pessoa_id) VALUES (2, '2026-06-15', '2026-07-30', 'A_NEGATIVO', 1, 2);
INSERT INTO tb_coleta (id, data_coleta, data_validade, tipo_sanguineo, hemocentro_id, pessoa_id) VALUES (3, '2026-06-28', '2026-08-12', 'AB_POSITIVO', 2, 3);

-- =================================================================================
-- 6. POPULANDO OS EXAMES REALIZADOS NAS COLETAS (tb_exame_coleta)
-- Depende de: tb_coleta e tb_exame
-- Enums válidos para situacao: 'POSITIVO', 'NEGATIVO', 'PENDENTE'
-- =================================================================================
-- Exames da Coleta 1 (Carlos Silva)
INSERT INTO tb_exame_coleta (id, coleta_id, exame_id, situacao) VALUES (1, 1, 1, 'NEGATIVO');
INSERT INTO tb_exame_coleta (id, coleta_id, exame_id, situacao) VALUES (2, 1, 2, 'NEGATIVO');

-- Exames da Coleta 2 (Ana Costa)
INSERT INTO tb_exame_coleta (id, coleta_id, exame_id, situacao) VALUES (3, 2, 1, 'POSITIVO');
INSERT INTO tb_exame_coleta (id, coleta_id, exame_id, situacao) VALUES (4, 2, 3, 'NEGATIVO');

-- Exames da Coleta 3 (Mariana Souza - Ainda em processamento)
INSERT INTO tb_exame_coleta (id, coleta_id, exame_id, situacao) VALUES (5, 3, 1, 'PENDENTE');
INSERT INTO tb_exame_coleta (id, coleta_id, exame_id, situacao) VALUES (6, 3, 2, 'PENDENTE');