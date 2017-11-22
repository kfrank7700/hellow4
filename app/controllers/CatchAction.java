/*package controllers;
import play.mvc.*;
import utils.ExceptionMailer;
import play.libs.F;
import play.Logger;

/**
 * Created by fkitema on 10/24/2017.

public class CatchAction extends Action.Simple {
    public F.Promise<SimpleResult> call(Http.Context ctx) throws RuntimeException {
        try {
            return delegate.call(ctx);
        } catch(Throwable e) {
            ExceptionMailer.send(e);
            throw new RuntimeException(e);
        }
    }
}
 */