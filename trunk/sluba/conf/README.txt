

Utilize os comandos abaixo no terminal, alterando os parametros:

[script sluba da pasta conf]: Arquivo script do compilador que se encontra na pasta deste arquivo de texto, que deve ser a pasta conf
[sluba.lang da pasta conf]: Arquivo da especificacao de highlight dos comandos para o gedit, testado apenas no ambiente Gnome
[n.n]: Versao do gtk instalada. a ultima versao disponivel eh a 3.0, deixando o nome da pasta como "gtksourceview-3.0"


Comandos para o terminal:


cp [script sluba da pasta conf] /usr/bin/
chmod +x /usr/bin/sluba
cp [sluba.lang da pasta conf] /usr/share/gtksourceview-[n.n]/language-specs/
