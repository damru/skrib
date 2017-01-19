package com.damienrubio.skrib;

import com.damienrubio.skrib.error.Criticity;
import com.damienrubio.skrib.error.InfoMessage;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.damienrubio.skrib.error.Criticity.ERROR;

/**
 * Created by damien on 15/01/2017.
 */
@Data
public class SkribContext extends ThreadLocal {
    private ArrayList<InfoMessage> messages;

    /**
     * Add a new exception.
     *
     * @param infoMessage
     */
    public void addMessage(InfoMessage infoMessage) {
        if (this.messages == null) {
            this.messages = new ArrayList<InfoMessage>();
        }
        this.messages.add(infoMessage);
    }

    /**
     * Check if there is message with specified criticity.
     *
     * @param criticity
     * @return
     */
    public boolean hasCriticity(Criticity criticity) {
        if (messages != null) {
            return messages.stream().anyMatch(infoMessage -> infoMessage.getCriticity() == criticity);
        }

        return false;
    }

    /**
     * Check if there is a message with ERROR criticty in the current context.
     *
     * @return
     */
    public boolean hasErrors() {
        return hasCriticity(Criticity.ERROR);
    }

    /**
     * Check if there is a message with WARNING criticty in the current context.
     *
     * @return
     */
    public boolean hasWarnings() {
        return hasCriticity(Criticity.WARNING);
    }

    /**
     * Check if there is a message with INFO criticty in the current context.
     *
     * @return
     */
    public boolean hasInfos() {
        return hasCriticity(Criticity.INFO);
    }

    /**
     * Get all messages with specified criticity.
     *
     * @param criticity
     * @return
     */
    public List<InfoMessage> getByCriticity(Criticity criticity) {
        if (messages != null) {
            return messages.stream().filter(infoMessage -> infoMessage.getCriticity() == criticity).collect(Collectors.toList());
        }
        return null;
    }

    public List<InfoMessage> getErrors() {
        return getByCriticity(ERROR);
    }

    public List<InfoMessage> getWarnings() {
        return getByCriticity(Criticity.WARNING);
    }

    public List<InfoMessage> getInfos() {
        return getByCriticity(Criticity.INFO);
    }
}
