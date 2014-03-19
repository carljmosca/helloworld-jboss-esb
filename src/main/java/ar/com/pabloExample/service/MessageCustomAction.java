package ar.com.pabloExample.service;

import java.util.Map;

import org.jboss.soa.esb.actions.AbstractActionPipelineProcessor;
import org.jboss.soa.esb.actions.ActionProcessingException;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.http.HttpRequest;
import org.jboss.soa.esb.message.Message;

public class MessageCustomAction extends AbstractActionPipelineProcessor {

    public MessageCustomAction(final ConfigTree config) {
        // extract configuration
    }

    @Override
    public Message process(Message message) throws ActionProcessingException {

        HttpRequest req = HttpRequest.getRequest(message);
        Map<String, String[]> params = req.getQueryParams();

        String name = params.get("name")[0];

        message.getBody().add("Hello " + name);

        return message;
    }
}
