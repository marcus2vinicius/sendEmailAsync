package br.marcus.mail.test;

import br.marcus.mail.send.MailSend;
import br.marcus.mail.send.MailTemplate;

import javax.mail.internet.AddressException;

/**
 * Created by marcus on 02/07/2015.
 */
public class Test {
    static MailTemplate mailTemplate;
    public static void main(String[] args) throws AddressException {
        montar();
        MailSend ms = new MailSend(mailTemplate);
        //Envio sincrono
        System.out.println("Solicitando...");
        ms.send();
        System.out.println("Enviado!");

        //Envio assincrono
        System.out.println("Solicitando...");
        ms.sendAsync();
        System.out.println("Solicitacao enviada!");
        /* Quer saber se foi enviado ? descomente abaixo...*/
        while (!ms.isSent()){}
        System.out.println("Enviado!");
    }

    private static void montar() {
        mailTemplate = new MailTemplate();
        mailTemplate.setFromEmail("viny.md01@gmail.com");//marcus.vinicius@facape.br, viny.md01@gmail.com
        mailTemplate.setFromName("Marcus Vinicius");
        mailTemplate.setSmtp("smtp.gmail.com");//smtp.gmail.com, smtp.office365.com
        mailTemplate.setLogin("viny.md01@gmail.com");//viny.md01@gmail.com, marcus.vinicius@facape.br
        mailTemplate.setPassword("sua senha aqui");
        mailTemplate.setSmtpPort(587);//587, 465
        mailTemplate.setTSL(true);
        mailTemplate.setMessage("Test de email em massa - NTI 2");
        mailTemplate.setSubject("Assunto Email Test 2");
        mailTemplate.addTo("viny.md@hotmail.com");
    }
}
