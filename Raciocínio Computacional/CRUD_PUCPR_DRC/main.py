'''
   Raciocínio Computacional
   CRUD - PUC-PR
   ATIVIDADE SOMATIVA 2 - Semana 8
   
   @Curso: Análise e Desenvolvimento de Sistemas
   @Autor: Matheus Vinicyus Strada
'''

import json

'''
    Leitura da opção dos dois menus (menu inicial e menu crud), com o tratamento de ERRO para as opções do menu.

    :return: Retorna um número da opção que esta disponivel no menu atual.
'''
def leitura_opcao_menu():
    while True:
        # Tratamento de Erro dos menus
        try:
            opcao = int(input("Digite um dos valores válido acima: "))
        # Caso de Erro de tipo ('String/Texto'), imprime uma mensagem
        except (ValueError, TypeError):
            mensagem_invalida()
        # Caso o usuário feche o sistema brutalmente (Ctrl + C)
        except KeyboardInterrupt:
            print("\n")
            opcao = 0        
            break
        # Caso de Sucesso!
        else:
            # Sai do loop se a entrada for válida
            break
    return opcao


'''
    Apresentação do menu inicial do sistema acadêmico.

    :return: Retorna uma chamada a função "leitura_opcao_menu", ou seja retorna um valor tratado e válido.
'''
def menu_inicial():
    print('='*35)
    print("{:^35}".format("Sistema Acadêmico"))
    print('='*35)
    print("1. Estudante")
    print("2. Disciplina")
    print("3. Professor")
    print("4. Turma")
    print("5. Matrícula")
    print("0. Sair\n")

    return leitura_opcao_menu()


'''
    Apresentação do menu de operação (CRUD).

    :return: Retorna uma chamada a função "leitura_opcao_menu", ou seja retorna um valor tratado e válido.
'''
def menu_CRUD(opcao):
    print('='*35)
    print("{:^35}".format(f"Menu de operações - {opcao}"))
    print('='*35)
    print("1. Incluir")
    print("2. Listar")
    print("3. Excluir")
    print("4. Alterar")
    print("5. Voltar\n")

    return leitura_opcao_menu()


'''
    Função responsavel por salvar os dados no arquivo JSON.

    :lista: Parâmetro obrigatório, lista onde deve armazenar os dados adicionados.
    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
'''
def salvar_arquivo_json(lista, arquivo_json):
    # Abrir o arquivo no modo de escrita.
    with open(arquivo_json, "w", encoding="utf-8") as arquivo:
        json.dump(lista, arquivo, ensure_ascii=False)


'''
    Função responsavel por ler os dados que estão no arquivo JSON.

    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
    :return: Retorna a lista com os dados.
'''
def ler_arquivo_json(arquivo_json):
    try:
        # Abrir o arquivo no modo de leitura.
        with open(arquivo_json, "r", encoding="utf-8") as arquivo:
            lista = json.load(arquivo)
    except:
        return []
    else:
        return lista


'''
    Operação 1 do menu do CRUD, função responsavel por incluir os dados.

    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
    :opcao_escola: Parâmetro obrigatório, é a opção do menu inicial (Estudante, Professor, Disciplina, Turma e Matrícula).
    :return: Retorna uma mensagem de Sucesso ou de Erro.
'''
def incluir(arquivo_json, opcao_escola):
    dicionario = {}
    # Leitura do dados já armazenados no arquivo json.
    lista = ler_arquivo_json(arquivo_json)

    # Tratamento de erro.
    try:
        # Caso seja uma das opções: Estudante, Professor, Disciplina ou Turma.
        if opcao_escola not in "Matrícula":
            # Leitura do código!
            codigo = int(input(f"Código do(a) {opcao_escola}: ")) # Todos tem, mas menos a Matrícula tem este dados!
            # Verifica se o Código informado já estão cadastrado no arquivo!
            if len(lista) > 0:
                for dados in lista:
                    if dados["Código"] == codigo:
                        print("!"*35)
                        print("{:^35}".format("ERRO, NO CADASTRO NÃO REALIZADO"))
                        print("{:^35}".format("Códigos já cadastrado."))
                        print("!"*35)
                        return "ERRO"

            # Caso seja uma das opções: Estudante, Professor ou Disciplina.
            if opcao_escola in ("Professor", "Estudante", "Disciplina"):
                # Leitura do nome!
                nome = input(f"Nome do(a) {opcao_escola}(a): ") # opções que tem este dado: Professor, Estudante e Disciplina!
                # Criação de um exceção/erro (Nome muito curto/inválido)!
                if len(nome) < 3:
                    raise Exception("Nome inválido")

                # Caso seja uma das opções: Estudante ou Professor.
                if opcao_escola in ("Professor", "Estudante"):
                    # Leitura do CPF
                    cpf = input(f"CPF do(a) {opcao_escola}(a): ") # opções que tem este dado: Professor e Estudante!

            # Caso seja a opção Turma.
            elif opcao_escola in "Turma":
                codigo_turma_professor = int(input(f"Código do(a) Professor(a): ")) # opção que tem este dado: Turma!
                codigo_turma_disciplina = int(input(f"Código do(a) Disciplina: ")) # opção que tem este dado: Turma!

                # Verifica se a turma com os códigos informados já estão cadastrados no arquivo!
                if len(lista) > 0:
                    for dados in lista:
                        if dados["Código_Professor"] == codigo_turma_professor and dados["Código_Disciplina"] == codigo_turma_disciplina:
                            print("!"*35)
                            print("{:^35}".format("ERRO, NO CADASTRO NÃO REALIZADO"))
                            print("{:^35}".format("Códigos: Professor e Diciplinas"))
                            print("{:^35}".format("Já foram cadastrados anteriormente."))
                            print("!"*35)
                            return "ERRO"

        # Caso seja a opção "Matrícula"
        elif opcao_escola in "Matrícula":
            codigo_matricula_turma = int(input(f"Código da Turma: ")) # opção que tem este dado:  Matrícula!
            codigo_matricula_estudante = int(input(f"Código do(a) Estudante: ")) # opção que tem este dado: Matrícula!

            # Verifica se a Matrícula com os códigos informados já estão cadastrados no arquivo!
            if len(lista) > 0:
                for dados in lista:
                    if dados["Código_Turma"] == codigo_matricula_turma and dados["Código_Estudante"] == codigo_matricula_estudante:
                        print("!"*35)
                        print("{:^35}".format("ERRO, CADASTRO NÃO REALIZADO"))
                        print("{:^35}".format("Códigos: Turma e Estudantes"))
                        print("{:^35}".format("Já foram cadastrados anteriormente."))
                        print("!"*35)
                        return "ERRO"
    # Caso de Erro
    except:
        mensagem_erro()
    # Caso de sucesso!
    else:
        # Caso seja uma das opções: Estudante, Professor, Disciplina ou Turma.
        if opcao_escola not in "Matrícula":
            dicionario["Código"] = codigo
            
            # Caso seja uma das opções: Disciplina, Professor ou Estudante.
            if opcao_escola in ("Professor", "Estudante", "Disciplina"):
                dicionario["Nome"] = nome

                # # Caso seja uma das opções: Professor ou Estudante.
                if opcao_escola in ("Professor", "Estudante"):
                    dicionario["CPF"] = cpf

            # Caso seja a opção: Turma.
            elif opcao_escola in "Turma":
                dicionario["Código_Professor"] = codigo_turma_professor
                dicionario["Código_Disciplina"] = codigo_turma_disciplina

        # Caso seja a opção: Matrícula.
        elif opcao_escola in "Matrícula":
            dicionario["Código_Turma"] = codigo_matricula_turma
            dicionario["Código_Estudante"] = codigo_matricula_estudante

        # Adiciona o dados na lista e salva no arquivo json!
        lista.append(dicionario)
        salvar_arquivo_json(lista, arquivo_json)
        return "{:^35}".format("Cadastrado com sucesso!")


'''
    Operação 2 do menu do CRUD, função responsavel por listar os dados do arquivo informado.

    :arquivo_json: Parâmetro obrigatório, arquivo json onde estão os dados guardados.
    :opcao_escola: Parâmetro obrigatório, é a opção do menu inicial (Estudante, Professor, Disciplina, Turma e Matrícula).
'''
def listar(arquivo_json, opcao_escola):
    # Leitura do dados já armazenados no arquivo json.
    lista = ler_arquivo_json(arquivo_json)
    # Verificar se a lista/arquivo tem dados.
    if len(lista) == 0:
        print("{:^35}".format("Não há cadastrado."))
        print("{:^35}".format("Acesse a opção de 'Incluir'"))
    else:
        # Listar os dados cadastradados!
        for dicionario in lista:
            # Caso seja uma das opções: Estudante, Professor, Disciplina ou Turma.
            if opcao_escola not in "Matrícula":
                print("{:^35}".format(f"Código do(a) {opcao_escola}: {dicionario['Código']}"))

                # Caso seja uma das opções: Disciplina, Professor ou Estudante.
                if opcao_escola in ("Professor", "Estudante", "Disciplina"):
                    print("{:^35}".format(f"Nome: {dicionario['Nome']}"))
                    
                    # Caso seja uma das opções: Professor ou Estudante.
                    if opcao_escola in ("Professor", "Estudante"):
                        print("{:^35}".format(f"CPF: {dicionario['CPF']}"))

                # Caso seja a opção: Turma.
                elif opcao_escola in "Turma":
                    print("{:^35}".format(f"Código da Disciplina: {dicionario['Código_Disciplina']}"))
                    print("{:^35}".format(f"Código do(a) Professor: {dicionario['Código_Professor']}"))


            # Caso seja a opção: Matrícula.
            elif opcao_escola in "Matrícula":
                print("{:^35}".format(f"Código da Turma: {dicionario['Código_Turma']}"))
                print("{:^35}".format(f"Código do(a) Estudante: {dicionario['Código_Estudante']}"))

            print("-"*35)
        input("Pressione enter para continuar!")


'''
    Operação 3 do menu do CRUD, função responsavel por exluir os dados do arquivo json infornado.

    :arquivo_json: Parâmetro obrigatório, arquivo json onde estão os dados guardados.
    :opcao_escola: Parâmetro obrigatório, é a opção do menu inicial (Estudante, Professor, Disciplina, Turma e Matrícula).
    :return: Retorna um valor verdadeiro ou falso, se foi exluido.
'''
def remover(arquivo_json, opcao_escola):
    # Tratamento de erro, para a leitura do código!
    try:
        # Caso seja uma das opções: Estudante, Professor, Disciplina ou Turma. 
        if opcao_escola not in "Matrícula":
            codigo_remocao = int(input("Informe o código: "))
        # Caso seja a opção: Matrícula.
        elif opcao_escola in "Matrícula":
            codigo_matricula_remocao_turma = int(input("Informe o código da Turma: "))
            codigo_matricula_remocao_estudante = int(input("Informe o código da Estudante: "))
    except:
        print("{:^35}".format("Não foi informou um número válido!"))
    else:
        # Leitura do dados já armazenados no arquivo json.
        lista = ler_arquivo_json(arquivo_json)
        # Variavel auxiliar para remoção dos dados na lista.
        variavel_aux_remocao = None
        # Percorrer a lista para verificar se o código digitado esta cadastrado
        for dicionario in lista:
            # Caso seja uma das opções: Estudante, Professor, Disciplina ou Turma.
            if opcao_escola not in "Matrícula":
                if dicionario["Código"] == codigo_remocao:
                    variavel_aux_remocao = dicionario
                    break
            # Caso seja a opção: Matrícula.
            elif opcao_escola in "Matrícula":
                if dicionario["Código_Turma"] == codigo_matricula_remocao_turma and dicionario["Código_Estudante"] == codigo_matricula_remocao_estudante:
                    variavel_aux_remocao = dicionario
                    break
        # Retorno se o dado foi ou não removido.
        if variavel_aux_remocao == None:
            return False
        else:
            lista.remove(variavel_aux_remocao)
            salvar_arquivo_json(lista, arquivo_json)
            return True


'''
    Operação 4 do menu do CRUD, função responsavel por Aleterar os dados contido no arquivo informado.

    :arquivo_json: Parâmetro obrigatório, arquivo json onde estão os dados guardados.
    :opcao_escola: Parâmetro obrigatório, é a opção do menu inicial (Estudante, Professor, Disciplina, Turma e Matrícula).
'''
def alterar(arquivo_json, opcao_escola):
    # Variavel auxiliar, recebe o retorno da função remover.
    verificar = remover(arquivo_json, opcao_escola)

    # Caso o código exista e tenha sido removido.
    if verificar:
        print("{:^35}".format("Informe os dados para a atualização!"))
        incluir(arquivo_json, opcao_escola)
        print("{:^35}".format("Atualização realizada com Sucesso!"))
    # Caso o código não esteja cadastrado no arquivo json.
    else:
        print("{:^35}".format("Verifique o código para edição"))


'''
    Apresentação da mensagem da operação que foi selecionada.

    :opcao: Parâmetro obrigatório, é o valor que o usuário informa no menu de operação (menu inicial e CRUD).
'''
def mensagem_operacao_realizada(opcao):
    print("+"*35)
    print("{:^35}".format(f"{opcao}"))
    print("+"*35)


'''
    Apresentação da mensagem de ERRO, para quando não é concluida a operação.
'''
def mensagem_erro():
    print("!"*35)
    print("{:^35}".format(f"ERRO - Informação não cadastrada"))
    print("!"*35)


'''
    Apresentação da mensagem de valor inválido, para quando o usuário informa um valor fora do range de opções.
'''
def mensagem_invalida():
    print("!"*35)
    print("{:^35}".format(f"ERRO - Opção inválida."))
    print("{:^35}".format(f"Tente novamente!"))
    print("!"*35)


'''
    Apresentação da mensagem de finalização do sistema, para quando o usuário finaliza o sistema.
'''
def mensagem_finalizar():
    print("~"*35)
    print("{:^35}".format("Obrigado por utilizar!"))
    print("{:^35}".format("Espero que tenha gostado!"))
    print("{:^35}".format("Sistema Finalizado!"))
    print("~"*35)


'''
    Função principal do sistema, função responsavel por executar o Sistema Acadêmico.
'''
def main():
    while True:
        # Apresentação e leitura do menu inicial.
        opcao_menu_inicial = menu_inicial()        

        # Opções válida do menu inical.
        if opcao_menu_inicial in (1, 2, 3, 4, 5):
            if opcao_menu_inicial == 1:
                escola_opcao = "Estudante"
                arquivo_json = "estudantes.json"
            elif opcao_menu_inicial == 2:
                escola_opcao = "Disciplina"
                arquivo_json = "disciplinas.json"
            elif opcao_menu_inicial == 3:
                escola_opcao = "Professor"
                arquivo_json = "professores.json"
            elif opcao_menu_inicial == 4:
                escola_opcao = "Turma"
                arquivo_json = "turmas.json"
            elif opcao_menu_inicial == 5:
                escola_opcao = "Matrícula"
                arquivo_json = "matriculas.json"
            while True:
                # Apresentação e leitura do menu do CRUD.
                opcao_crud = menu_CRUD(escola_opcao)

                # Opção de Incluir.
                if opcao_crud == 1:
                    crud = "Incluir"
                    mensagem_operacao_realizada(crud)
                    incluir(arquivo_json, escola_opcao)

                # Opção de Listar
                elif opcao_crud == 2:
                    crud = "Listar"
                    mensagem_operacao_realizada(crud)
                    listar(arquivo_json, escola_opcao)

                # Opção de Excluir
                elif opcao_crud == 3:
                    crud = "Excluir"
                    mensagem_operacao_realizada(crud)
                    foi_removido = remover(arquivo_json, escola_opcao)
                    if foi_removido:
                        print("{:^35}".format("Removido da base de dados!"))
                    else:
                        print("{:^35}".format("Código informado não encontrado!"))

                # Opção de Alterar
                elif opcao_crud == 4:
                    crud = "Alterar"
                    mensagem_operacao_realizada(crud)
                    alterar(arquivo_json, escola_opcao)

                # Voltar para o menu inicial.
                elif opcao_crud == 5:
                    break

                # Opção inválida da váriavel "opcao_crud"
                else:
                    mensagem_invalida()

        # Opção para saír do Sistema (menu inicial)!
        elif opcao_menu_inicial == 0:
            break

        # Opção inválida do menu inicial, váriavel "opcao_menu_inicial"
        else:
            mensagem_invalida()

    # Mensagem de finalização do Sistema
    mensagem_finalizar()


# Execução da função principal!
main()
