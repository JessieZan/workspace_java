package br.com.isidrocorp.acme.ui;

import java.util.ArrayList;

import br.com.isidrocorp.acme.repo.FuncionarioRepo;
import br.com.isidrocorp.acme.repo.RepositorioEmArquivo;
import br.com.isidrocorp.acme.repo.RepositorioEmMemoria;
import br.com.isidrocorp.acme.root.Funcionario;
import br.com.isidrocorp.exceptions.DadosInvalidosException;
import br.com.isidrocorp.exceptions.EstruturaDeFuncionarioInvalida;
import br.com.isidrocorp.exceptions.TipoFuncionarioInvalidoException;

public class FolhaDePagamento {
	public static void main(String[] args) {

		/* rotina para ler arquivos */
		ArrayList<Funcionario> lista;

		try {
			FuncionarioRepo repo = new RepositorioEmArquivo();
			//FuncionarioRepo repo = new RepositorioEmMemoria();
						
			lista = repo.lerTudo();
			
			for (Funcionario f : lista) {
				System.out.println("|   |----------------------------------------------------|   |");
				System.out.printf("| o | Nome: %-30s R$ %10.2f | o |\n", f.getNome(), f.calcularSalario());
			}
		} catch (DadosInvalidosException ex) {
			System.err.println("Dados do cadastro de funcionario Invalido");
		} catch (TipoFuncionarioInvalidoException ex) {
			System.out.println("N�o tem regra para est tipo de funcionario");
		} catch (EstruturaDeFuncionarioInvalida ex) {
			System.err.println("Funcionario com estrutura de informa��o Inv�lida");
		} catch (Exception ex) {
			System.err.println("Erro desconhecido");
		}
	}

}