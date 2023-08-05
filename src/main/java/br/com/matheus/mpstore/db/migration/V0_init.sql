SELECT constraint_name FROM information_schema.constraint_column_usage 
WHERE table_name = 'usuario_acesso' 
AND column_name = 'acesso_id' AND constraint_name <> 'unique_acesso_user';

ALTER TABLE usuario_acesso DROP CONSTRAINT "uk_fhwpg5wu1u5p306q8gycxn9ky";