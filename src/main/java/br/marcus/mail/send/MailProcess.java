package br.marcus.mail.send;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import javax.mail.internet.InternetAddress;
import java.util.List;

/**
 * Created by marcus on 02/07/2015.
 */
public class MailProcess {
    private HtmlEmail email;
    private boolean sent;
    private MailTemplate mail;

    public MailProcess(MailTemplate mail){
        email = new HtmlEmail();
        this.mail = mail;
    }

    public void send(){
        try {
            email = new HtmlEmail();
            email.setHostName(mail.getSmtp());
            email.setSmtpPort(mail.getSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(mail.getLogin(), mail.getPassword()));
            email.setSSL(mail.isSSL());
            email.setTLS(mail.isTSL());
            email.setFrom(mail.getFromEmail(), mail.getFromName());
            email.setSubject(mail.getSubject());
            email.setHtmlMsg(mail.getMessage());
            addTo(mail.getToInternetAddress());
            addToCC(mail.getToCCInternetAddress());
            addToCCO(mail.getToCCOInternetAddress());
            email.send();
            sent = true;
        }catch (Exception e){e.printStackTrace();}
    }

    private void addToCCO(List<InternetAddress> destinatariosCCO) {
        try {
            email.setBcc(destinatariosCCO);
        } catch (EmailException e) {}
    }

    private void addToCC(List<InternetAddress> destinatariosCC) {
        try {
            email.setCc(destinatariosCC);
        }catch (Exception e){}
    }

    private void addTo(List<InternetAddress> destinatarios) {
        if(!destinatarios.isEmpty())
            try {
                email.setTo(destinatarios);
            } catch (EmailException e) {}
    }

    public boolean isSent() {
        return sent;
    }
}
