package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.system.dto.UserDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.learningenglish.utils.cache.UserCache;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;
import com.sillyhat.swing.module.container.table.SillyHatTable;
import com.sillyhat.swing.utils.StringUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${XUSHIKUAN} on 2017-03-13.
 */
public class RemoveWordRepositoryListener implements ActionListener {

    private WordRepositoryService wordRepositoryService;

    private MessageService messageService;

    private SillyHatTable table;

    public RemoveWordRepositoryListener(SillyHatTable table){
        this.table = table;
        wordRepositoryService = (WordRepositoryService) SpringUtils.getInstance().getContext().getBean(WordRepositoryService.class);
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = (String)table.getValueAt(table.getSelectedRow(), 0);
        if(StringUtils.isEmpty(id)){
            SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.reminder.select.data"));
        }else{
            if(SillyHatJOptionPane.confirm(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.reminder.remove")) == SillyHatJOptionPane.OK_OPTION){
                wordRepositoryService.deleteWordRepository(id);
                SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.reminder.remove.success"));
            }
        }
    }
}
