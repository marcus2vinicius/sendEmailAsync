package br.marcus.mail.send;

/**
 * Created by marcus on 03/07/2015.
 */
public class MailSend {
    private Thread threadMainAsync;
    private boolean isAsync;
    private MailProcess mailProcess;
    private MailTemplate mailTemplate;

    public MailSend(MailTemplate mail){
        mailTemplate = mail;
        mailProcess = new MailProcess(mailTemplate);
    }

    public void send(){
        mailProcess.send();
    }

    public void sendAsync(){
        isAsync = true;
        Runnable r = new Runnable() {
            public void run() {
                mailProcess.send();
            }
        };
        threadMainAsync = new Thread(r);
        threadMainAsync.start();
    }

    public boolean isSent(){
        if(isAsync)
            return threadMainAsync.getState().equals(Thread.State.TERMINATED) && mailProcess.isSent();
        return mailProcess.isSent();
    }
}
