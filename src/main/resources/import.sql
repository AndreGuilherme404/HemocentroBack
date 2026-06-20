-- ==========================================
-- 1. INSERINDO HEMOCENTROS (tb_hemocentro)
-- Apenas ID e descricao, conforme sua classe.
-- ==========================================
INSERT INTO tb_hemocentro (id, descricao) VALUES (1, 'Hemocentro Central de Belo Horizonte');
INSERT INTO tb_hemocentro (id, descricao) VALUES (2, 'Posto de Coleta Universitário');
INSERT INTO tb_hemocentro (id, descricao) VALUES (3, 'Hemocentro Regional Contagem');
INSERT INTO tb_hemocentro (id, descricao) VALUES (4, 'Unidade Móvel de Coleta - Praça da Liberdade');
INSERT INTO tb_hemocentro (id, descricao) VALUES (5, 'Posto Avançado Pampulha');

-- ==========================================
-- 2. INSERINDO PESSOAS (tb_pessoa)
-- ==========================================

INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES(1, 'André Guilherme', '111.111.111-11', 'andre@email.com');
INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES(2, 'Maria Silva', '222.222.222-22', 'maria@email.com');
INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES(3, 'João Souza', '333.333.333-33', 'joao@email.com');
INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES(4, 'Ana Oliveira', '444.444.444-44', 'ana@email.com');
INSERT INTO tb_pessoa (id, nome, cpf, email) VALUES(5, 'Carlos Eduardo', '555.555.555-55', 'carlos@email.com');

-- ==========================================
-- 3. INSERINDO USUARIOS (tb_usuario)
-- tipo_perfil: 0 (USUARIO), 1 (FUNCIONARIO), 2 (GERENTE)
-- Assumindo o enum padrão numérico do JPA.
-- ==========================================

INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id) VALUES(1, 'gerente', 'gerente', 2, 1);
INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id) VALUES(2, 'funcionario', 'funcionario', 1, 2);
INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id) VALUES(3, 'usuario', 'usuario', 0, 3);
INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id) VALUES(4, 'ana.doadora', 'senha123', 0, 4);
INSERT INTO tb_usuario (id, login, senha, tipo_perfil, pessoa_id) VALUES(5, 'carlos.doador', 'senha123', 0, 5);

-- ==========================================
-- 4. INSERINDO EXAMES (tb_exame)
-- Bateria de exames obrigatórios.
-- ==========================================

INSERT INTO tb_exame (id, nome, descricao) VALUES(1, 'NAT - HIV', 'Teste de Ácido Nucleico para detecção do vírus HIV.');
INSERT INTO tb_exame (id, nome, descricao) VALUES(2, 'NAT - HBV / HCV', 'Teste de Ácido Nucleico para detecção de Hepatite B e C.');
INSERT INTO tb_exame (id, nome, descricao) VALUES(3, 'Anti-HCV', 'Pesquisa de anticorpos contra o vírus da Hepatite C.');
INSERT INTO tb_exame (id, nome, descricao) VALUES(4, 'VDRL', 'Teste sorológico para detecção de anticorpos para Sífilis.');
INSERT INTO tb_exame (id, nome, descricao) VALUES(5, 'Doença de Chagas', 'Pesquisa de anticorpos contra o protozoário Trypanosoma cruzi.');
INSERT INTO tb_exame (id, nome, descricao) VALUES(6, 'Anti-HTLV I/II', 'Pesquisa de anticorpos contra os vírus linfotrópicos humanos.');
INSERT INTO tb_exame (id, nome, descricao) VALUES(7, 'Tipagem ABO', 'Identificação do grupo sanguíneo do doador.');
INSERT INTO tb_exame (id, nome, descricao) VALUES(8, 'Fator RhD', 'Identificação do fator Rhesus (Positivo ou Negativo).');

-- ==========================================
-- 5. INSERINDO EXAMES DA COLETA (tb_exame_coleta)
-- O resultado é Boolean (false = não reagente/normal, true = reagente/alterado)
-- ==========================================

INSERT INTO tb_exame_coleta (id, resultado, exame_id) VALUES(1, 0, 1);
INSERT INTO tb_exame_coleta (id, resultado, exame_id) VALUES(2, 0, 2);
INSERT INTO tb_exame_coleta (id, resultado, exame_id) VALUES(3, 1, 3);
INSERT INTO tb_exame_coleta (id, resultado, exame_id) VALUES(4, 1, 4);
INSERT INTO tb_exame_coleta (id, resultado, exame_id) VALUES(5, 2, 5); -- Exemplo de um exame que deu alteração

-- ==========================================
-- 6. INSERINDO COLETAS (tb_coleta)
-- ==========================================

INSERT INTO tb_coleta (id, data_coleta, data_validade, hemocentro_id, pessoa_id) VALUES(1, '2026-06-01', '2026-07-06', 1, 1);
INSERT INTO tb_coleta (id, data_coleta, data_validade, hemocentro_id, pessoa_id) VALUES(2, '2026-06-05', '2026-07-10', 2, 4);
INSERT INTO tb_coleta (id, data_coleta, data_validade, hemocentro_id, pessoa_id) VALUES(3, '2026-06-10', '2026-07-15', 3, 5);
INSERT INTO tb_coleta (id, data_coleta, data_validade, hemocentro_id, pessoa_id) VALUES(4, '2026-06-12', '2026-07-17', 1, 1);
INSERT INTO tb_coleta (id, data_coleta, data_validade, hemocentro_id, pessoa_id) VALUES(5, '2026-06-15', '2026-07-20', 4, 4);

-- ==========================================
-- 7. ASSOCIANDO COLETAS E EXAMES_COLETA (tb_coleta_exame)
-- Tabela gerada pelo @ManyToMany e @JoinTable
-- ==========================================

INSERT INTO tb_coleta_exame (coleta_id, exame_id) VALUES(1, 1);
INSERT INTO tb_coleta_exame (coleta_id, exame_id) VALUES(1, 2);
INSERT INTO tb_coleta_exame (coleta_id, exame_id) VALUES(2, 3);
INSERT INTO tb_coleta_exame (coleta_id, exame_id) VALUES(3, 4);
INSERT INTO tb_coleta_exame (coleta_id, exame_id) VALUES(4, 5);