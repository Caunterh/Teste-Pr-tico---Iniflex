package com.caunter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** 
 * @author CauaSouzaCorrea
 * **/
public class Principal {
	
	public static void main(String[] args) {
		List<Funcionario> listaDeFunc = new ArrayList<>();
		
		listaDeFunc.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        listaDeFunc.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        listaDeFunc.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        listaDeFunc.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        listaDeFunc.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        listaDeFunc.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        listaDeFunc.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        listaDeFunc.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        listaDeFunc.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        listaDeFunc.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        
        //Remove o João da lista.
        listaDeFunc.remove(1);
        
        //Formata a data de nascimento.
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        //Imprime todos os funcionarios.
        for(Funcionario f: listaDeFunc) {
        	System.out.println("Nome |      Data Nascimento |        Salário |       Função");        	
            System.out.println(f.getNome() + "     |     " +  f.getDtNascimento().format(formatador) + "     |     " +  String.format("%,.2f", f.getSalario()) + "     |    " +  f.getFuncao());
            System.out.println();
        }
        
        System.out.println("----------"); 
        
        //Atualiza o salarios dos funcionarios com um aumento de 10%.
        System.out.println("Lista atualizada dos salarios: ");
        for(Funcionario f: listaDeFunc) {
        	f.setSalario(f.getSalario().multiply(BigDecimal.valueOf(1.10)));
        	
        	System.out.println(f.getNome() + " : " + f.getSalario());        
        
	}
        System.out.println("----------");
        
        //Agrupa os funcionários por função em um MAP.  Imprimi os funcionários agrupados por função.
        Map<String, List <Funcionario>> funcionariosPorFunc = listaDeFunc.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        for(String funcao: funcionariosPorFunc.keySet()) {
        	System.out.println("Função: " + funcao);
        	for(Funcionario f: funcionariosPorFunc.get(funcao)) {
        		System.out.println(" - " + f.getNome());
        	}
        }
        
        System.out.println("----------");
        
        //Imprimi os funcionarios que fazem aniversario no mês 10 e 12.
        System.out.println("Aniversariantes do mês 10 e 12: ");
        for(Funcionario f: listaDeFunc) {
        	int mesNasc = f.getDtNascimento().getMonthValue();
        	if(mesNasc == 10 || mesNasc == 12) {
        		System.out.println(" - " + f.getNome());
        	}
        }
        
        System.out.println("----------");
        
        //Imprimi o funcionario mais velho.
        System.out.println("Funcionario mais velho: ");        

        Funcionario funcMaisVelho = null;
        
        int maisVelho = Integer.MAX_VALUE;
        
        for(Funcionario f: listaDeFunc) {
        	int anoNasc = f.getDtNascimento().getYear();
        	if(anoNasc  < maisVelho) {   
        		maisVelho = anoNasc;
        		funcMaisVelho = f;
        	}        	
        }       
        
        
        int idadeMaisVelho = funcMaisVelho.getDtNascimento().getYear();
        
        if(funcMaisVelho != null) {
        	int idade = (2024 - idadeMaisVelho);
        	System.out.println(" - " + funcMaisVelho.getNome() + " " + idade);
        }
        
        
        System.out.println("----------");
        
        //Imprimi os funcionarios em ordem alfabetica.
        System.out.println("Ordem alfabetica: ");
        
        List<Funcionario> ordemAlfa = new ArrayList<>(listaDeFunc);
        ordemAlfa.sort(Comparator.comparing(Funcionario::getNome));
        for(Funcionario f:ordemAlfa) {
        	System.out.println(" - " + f.getNome());
        }
        
        System.out.println("----------");
        
        //Soma todos os salarios.
        BigDecimal soma = new BigDecimal(0.0);        
        for(Funcionario f: listaDeFunc) {
        	soma = soma.add(f.getSalario());
        }
        System.out.println("A soma total dos salarios é: ");
        System.out.println(" - " +soma);
        
        System.out.println("----------");
        
        //Quantos salarios minimos cada funcionario recebe.
        BigDecimal salarioMin = new BigDecimal(1212.000);
        BigDecimal resultado;
        
        for(Funcionario f:listaDeFunc) {
        	BigDecimal salariosMinimos = f.getSalario();
        	resultado = salariosMinimos.divide(salarioMin, 1, RoundingMode.UP);
        	System.out.println("O total de salarios minimos que o funcionario(a) " + f.getNome() + " recebe é: " + resultado);
        }
  }
}
