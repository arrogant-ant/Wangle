package ambastha.wangle;

/**
 * Created by Sabita_Sant on 11/03/17.
 */

public class Request {
    String siteManager, resType, resNo;

    Request(String siteManager, String resType, String resNo) {
        this.siteManager = siteManager;
        this.resType = resType;
        this.resNo = resNo;
    }
}
