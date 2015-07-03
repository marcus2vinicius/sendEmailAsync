package br.marcus.mail.send;

import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus on 02/07/2015.
 */
public class MailTemplate {
    private String FromName;
    private String Subject;
    private String FromEmail;
    private String Message;
    private String Password;
    private String Login;
    private String Smtp;
    private Integer SmtpPort;
    private boolean SSL;
    private boolean TSL;
    private List<InternetAddress> ToInternetAddress;
    private List<InternetAddress> ToCCInternetAddress;
    private List<InternetAddress> ToCCOInternetAddress;


    public MailTemplate(){
        ToInternetAddress    = new ArrayList<InternetAddress>();
        ToCCInternetAddress  = new ArrayList<InternetAddress>();
        ToCCOInternetAddress = new ArrayList<InternetAddress>();
    }


    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSmtp() {
        return Smtp;
    }

    public void setSmtp(String smtp) {
        Smtp = smtp;
    }

    public Integer getSmtpPort() {
        return SmtpPort;
    }

    public void setSmtpPort(Integer smtpPort) {
        SmtpPort = smtpPort;
    }

    public List<InternetAddress> getToInternetAddress() {
        return ToInternetAddress;
    }

    public void setToInternetAddress(List<InternetAddress> toInternetAddress) {
        ToInternetAddress = toInternetAddress;
    }

    public List<InternetAddress> getToCCInternetAddress() {
        return ToCCInternetAddress;
    }

    public void setToCCInternetAddress(List<InternetAddress> toCCInternetAddress) {
        ToCCInternetAddress = toCCInternetAddress;
    }

    public List<InternetAddress> getToCCOInternetAddress() {
        return ToCCOInternetAddress;
    }

    public void setToCCOInternetAddress(List<InternetAddress> toCCOInternetAddress) {
        ToCCOInternetAddress = toCCOInternetAddress;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getFromName() {
        return FromName;
    }

    public void setFromName(String fromName) {
        FromName = fromName;
    }

    public String getFromEmail() {
        return FromEmail;
    }

    public void setFromEmail(String fromEmail) {
        FromEmail = fromEmail;
    }

    public boolean isSSL() {
        return SSL;
    }

    public void setSSL(boolean SSL) {
        if(TSL)
            TSL = !SSL;
        this.SSL = SSL;
    }

    public boolean isTSL() {
        return TSL;
    }

    public void setTSL(boolean TSL) {
        if(SSL)
            SSL = !TSL;
        this.TSL = TSL;
    }

    public void addTo(String email){
        addTo(email, "");
    }

    public void addTo(String email, String name){
        try{
            if(!name.isEmpty() && !email.isEmpty())
                ToInternetAddress.add(new InternetAddress(email,name));
            else if (!email.isEmpty())
                ToInternetAddress.add(new InternetAddress(email,name));
        }catch (Exception e){}
    }

    public void addToCC(String email){
        addToCC(email, "");
    }

    public void addToCC(String email, String name){
        try{
            if(!name.isEmpty() && !email.isEmpty())
                ToCCInternetAddress.add(new InternetAddress(email,name));
            else if (!email.isEmpty())
                ToCCInternetAddress.add(new InternetAddress(email,name));
        }catch (Exception e){}
    }

    public void addToCCO(String email){
        addToCCO(email, "");
    }

    public void addToCCO(String email, String name){
        try{
            if(!name.isEmpty() && !email.isEmpty())
                ToCCOInternetAddress.add(new InternetAddress(email,name));
            else if (!email.isEmpty())
                ToCCOInternetAddress.add(new InternetAddress(email,name));
        }catch (Exception e){}
    }
}
