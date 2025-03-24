// ARQUIVO QUE DEFINE AS NOTIFICAÇÕES
package br.edu.ifpi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoEmail {

    @Autowired
    private JavaMailSender mailSender;

    public void notificarEmprestimo(String destinatario, String titulo){
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom("cdav896@gmail.com");
        mensagem.setTo(destinatario);
        mensagem.setSubject("NOTIFICAÇÃO DE EMPRÉSTIMO - BIBLIOTECA UM BOOKADO");
        mensagem.setText("\n O livro "+ titulo +" emprestado para " + destinatario + ".");
        
        mailSender.send(mensagem);
    } 

    public void notificarDevolucao(String destinatario, String titulo) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom("cdav896@gmail.com");
        mensagem.setTo(destinatario);
        mensagem.setSubject("NOTIFICAÇÃO DE DEVOLUÇÃO - BIBLIOTECA UM BOOKADO");
        mensagem.setText("\nO livro " + titulo + " foi devolvido por " + destinatario + ".");
    
        mailSender.send(mensagem);
    }

    // public void notificarCadastroUsuario(String destinatario, String nome){
    //     SimpleMailMessage mensagem = new SimpleMailMessage();
    //     mensagem.setFrom("cdav896@gmail.com");
    //     mensagem.setTo(destinatario);
    //     mensagem.setSubject("NOTIFICAÇÃO DE CADASTRO DE USUÁRIO - BIBLIOTECA UM BOOKADO");
    //     mensagem.setText("\n Usuário cadastrado: "+ nome +"\nEmail do usuário cadastrado: " + destinatario + ".");
        
    //     mailSender.send(mensagem);
    // } 
}
