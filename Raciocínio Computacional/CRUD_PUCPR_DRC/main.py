'''
   Raciocínio Computacional
   CRUD - PUC-PR
   ATIVIDADE FORMATIVA - Semana 7
   
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

    :lista: Parâmetro obrigatório, lista onde deve informação adicionar.
    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
'''
def salvar_arquivo_json(lista, arquivo_json):
    with open(arquivo_json, "w", encoding="utf-8") as arquivo:
        json.dump(lista, arquivo, ensure_ascii=False)
        arquivo.close()


'''
    Função responsavel por ler os dados que estão no arquivo JSON.

    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
    :return: Retorna a lista com os dados.
'''
def ler_arquivo_json(arquivo_json):
    try:
        with open(arquivo_json, "r", encoding="utf-8") as arquivo:
            lista = json.load(arquivo)
    except:
        return []
    else:
        return lista
    finally:
        arquivo.close()


'''
    Operação 1 do menu do CRUD, função responsavel por incluir os dados.

    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
    :return: Retorna uma mensagem de Sucesso ou de Erro.
'''
def incluir(arquivo_json):
    dicionario = {}
    # Tratamento de erro.
    try:
        # Leitura do código!
        codigo = int(input("Código: "))
        
        # Leitura do nome!
        nome = input(f"Nome: ")
        # Criação de um exceção/erro (Nome muito curto/inválido)!
        if len(nome) < 3:
            raise Exception("Nome inválido")
        
        # Leitura do CPF
        cpf = input("CPF: ")

    # Caso de Erro
    except:
        mensagem_erro()
    # Caso de sucesso!
    else:
        dicionario["Código"] = codigo
        dicionario["Nome"] = nome
        dicionario["CPF"] = cpf

        lista = ler_arquivo_json(arquivo_json)
        lista.append(dicionario)
        salvar_arquivo_json(lista, arquivo_json)
        return "{:^35}".format("Cadastrado com sucesso!")


'''
    Operação 2 do menu do CRUD, função responsavel por listar os dados na lista infornada.

    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
'''
def listar(arquivo_json):
    lista = ler_arquivo_json(arquivo_json)
    # Verificar se a lista/arquivo tem dados.
    if len(lista) == 0:
        print("{:^35}".format("Não há cadastrado."))
        print("{:^35}".format("Acesse a opção de 'Incluir'"))
    else:
        # Listar os dados cadastradados!
        for dicionario in lista:
            print("{:^35}".format(f"Código: {dicionario['Código']}"))
            print("{:^35}".format(f"Nome: {dicionario['Nome']}"))
            print("{:^35}".format(f"CPF: {dicionario['CPF']}"))
            print("-"*35)
        input("Pressione enter para continuar!")


'''
    Operação 3 do menu do CRUD, função responsavel por exluir os dados da lista infornada.

    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
    :return: Retorna um valor verdadeiro ou falso, se foi exluido.
'''
def remover(arquivo_json):
    # Tratamento de erro, para a leitura do código!
    try:
        codigo_remocao = int(input("Informe o código: "))
    except:
        print("{:^35}".format("Você não informou um número ou código válido!"))
    else:
        lista = ler_arquivo_json(arquivo_json)
        # Variavel auxiliar para remoção dos dados na lista.
        variavel_aux_remocao = None
        # Percorrer a lista para verificar se o código digitado esta cadastrado
        for dicionario in lista:
            if dicionario["Código"] == codigo_remocao:
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
    Operação 4 do menu do CRUD, função responsavel por Aleterar os dados da lista informada.

    :arquivo_json: Parâmetro obrigatório, arquivo onde estão os dados guardados.
'''
def alterar(arquivo_json):
    # Variavel auxiliar, serve para verificar se o código existe.
    verificar = remover(arquivo_json)

    # Caso o código exista.
    if verificar:
        print("{:^35}".format("Informe os dados para a atualização!"))
        incluir(arquivo_json)
        print("{:^35}".format("Atualização realizada com Sucesso!"))
    # Caso o código não está cadastrado.
    else:
        print("{:^35}".format("Verifique o código para edição"))


'''
    Apresentação da mensagem das operações que estão em desenvolimento.

    :opcao: Parâmetro obrigatório, é o valor que o usuário informa no menu de operação (menu inicial e CRUD).
'''
def mensagem_opcao_desenvolvimento(opcao):
    print("-"*35)
    print("{:^35}".format("EM DESENVOLVIMENTO!!!"))
    print("{:^35}".format(f"A opção: '{opcao}' está desativada."))
    print("{:^35}".format("Tente outra opção!"))
    print("-"*35)


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
    # Declarando o nome dos arquivos.
    arquivo_esdutante = "estudantes.json"
    arquivo_professor = "professores.json"
    arquivo_disciplina = "disciplinas.json"
    arquivo_turma = "turmas.json"
    arquivo_matricula = "matriculas.json"

    while True:
        # Apresentação e leitura do menu inicial.
        opcao_menu_inicial = menu_inicial()        

        # Opções em desenvolvimento!
        if opcao_menu_inicial in (2, 3, 4, 5):
            if opcao_menu_inicial == 2:
                escola_opcao = "Disciplina"
            elif opcao_menu_inicial == 3:
                escola_opcao = "Professor"
            elif opcao_menu_inicial == 4:
                escola_opcao = "Turma"
            elif opcao_menu_inicial == 5:
                escola_opcao = "Matrícula"

            mensagem_opcao_desenvolvimento(escola_opcao)

        # Opções válida do menu inical.
        elif opcao_menu_inicial == 1:
            escola_opcao = "Estudante"
            while True:
                # Apresentação e leitura do menu do CRUD.
                opcao_crud = menu_CRUD(escola_opcao)

                # Opção de Incluir.
                if opcao_crud == 1:
                    crud = "Incluir"
                    mensagem_operacao_realizada(crud)
                    incluir(arquivo_esdutante)

                # Opção de Listar
                elif opcao_crud == 2:
                    crud = "Listar"
                    mensagem_operacao_realizada(crud)
                    listar(arquivo_esdutante)

                # Opção de Excluir
                elif opcao_crud == 3:
                    crud = "Excluir"
                    mensagem_operacao_realizada(crud)
                    foi_removido = remover(arquivo_esdutante)
                    if foi_removido:
                        print("{:^35}".format("Removido da base de dados!"))
                    else:
                        print("{:^35}".format("Código informado não encontrado!"))

                # Opção de Alterar
                elif opcao_crud == 4:
                    crud = "Alterar"
                    mensagem_operacao_realizada(crud)
                    alterar(arquivo_esdutante)

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
