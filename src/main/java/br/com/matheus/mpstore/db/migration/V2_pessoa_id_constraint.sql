CREATE OR REPLACE FUNCTION validaChavePessoa()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
AS $$
	DECLARE existe INTEGER;
	BEGIN
		existe = (SELECT COUNT(1) FROM pessoa_fisica WHERE id = NEW.pessoa_id);
		IF (existe <= 0) THEN
			existe = (SELECT COUNT(1) FROM pessoa_juridica WHERE id = NEW.pessoa_id);
			IF (existe <= 0) THEN
				RAISE EXCEPTION 'Não foi encontrado o ID e PK da Pessoa para realizar a associação de cadastro';
			END IF;
		END IF;
		RETURN NEW;
	END;
$$

CREATE OR REPLACE FUNCTION validaChavePessoaFornecedor()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
AS $$
	DECLARE existe INTEGER;
	BEGIN
		existe = (SELECT COUNT(1) FROM pessoa_fisica WHERE id = NEW.pessoa_fornecedor_id);
		IF (existe <= 0) THEN
			existe = (SELECT COUNT(1) FROM pessoa_juridica WHERE id = NEW.pessoa_fornecedor_id);
			IF (existe <= 0) THEN
				RAISE EXCEPTION 'Não foi encontrado o ID e PK da Pessoa para realizar a associação de cadastro';
			END IF;
		END IF;
		RETURN NEW;
	END;
$$

CREATE TRIGGER validaChavePessoaUpdate
	BEFORE UPDATE
	ON conta_pagar
	FOR EACH ROW
	EXECUTE PROCEDURE validaChavePessoa();

CREATE TRIGGER validaChavePessoaInsert
	BEFORE INSERT
	ON conta_pagar
	FOR EACH ROW
	EXECUTE PROCEDURE validaChavePessoa();

CREATE TRIGGER validaChavePessoaFornecedorUpdate
	BEFORE UPDATE
	ON conta_pagar
	FOR EACH ROW
	EXECUTE PROCEDURE validaChavePessoaFornecedor();

CREATE TRIGGER validaChavePessoaFornecedorInsert
	BEFORE INSERT
	ON conta_pagar
	FOR EACH ROW
	EXECUTE PROCEDURE validaChavePessoaFornecedor();