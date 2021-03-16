
--############################## CARGA DE DADOS E TABELAS DE DOMÍNIO ##############################

-- Carga na tabela Aviao
INSERT INTO public.aviao(id_aviao)VALUES (1);

-- Carga na tabela Piloto 
INSERT INTO public.piloto(id_piloto, cpf, nome, stat_voo)VALUES (1, '09534598734', 'Luccas Carlos', true);

-- Carga na tabela Status Voo 
INSERT INTO public.status_voo(id_status_voo, stat_voo) VALUES (1, 'Aguardando Decolagem');

-- Carga na tabela Status Tipo de Voo 
INSERT INTO public.tipo_voo(id_tipo_voo, desc_tipo_voo, sigl_tipo_voo) VALUES (1, 'Comercial', 'COM');
	
--Carga na tabela Voo
INSERT INTO public.voo(id_voo, desc_voo, hora_chegada, hora_partida, nome_aeroporto_destino, nome_aeroporto_origem, id_aviao, id_piloto, id_status_voo, id_tipo_voo) VALUES (1, 'Voo 1', '01/01/2021', '02/01/2021', 'Galeao', 'Pinto Martins', 1, 1, 1, 1);

--Carga na tabela Cidade
INSERT INTO public.cidade(id_cidade, estado, nome) VALUES (1, 'CE', 'FORTALEZA');

--Carga na tabela Aeroporto
INSERT INTO public.aeroporto(id_aeroporto, latitude, longetude, nome_aeroporto, sigl_aeroporto, id_cidade) VALUES (1, -3.7760207129917815, -38.5330966, 'Pinto Martins', 'PTMT', 1);

--Carga na tabela VooAeroporto
INSERT INTO public.voo_aeroporto(id_aeroporto, id_voo, sentido)	VALUES (1, 1, 'Ida');


