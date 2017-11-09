package controllers;

/**
 * Created by fkitema on 10/24/2017.
 */
public class CatchAction extends Action.Simple {
    public F.Promise<SimpleResult> call(Http.Context ctx) {
        try {
            return delegate.call(ctx);
        } catch(Throwable e) {
            ExceptionMailer.send(e);
            throw new RuntimeException(e);
        }
    }
}