package org.geekster;



import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Component
public class CustomizedMailAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication("jamsheed01234.jk@gmail.com", "dhyyreexllmyvpgx");

    }
}
