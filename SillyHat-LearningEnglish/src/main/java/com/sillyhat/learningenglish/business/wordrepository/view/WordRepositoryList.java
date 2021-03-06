package com.sillyhat.learningenglish.business.wordrepository.view;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.listener.WordRepositoryDetailListener;
import com.sillyhat.learningenglish.business.wordrepository.listener.WordRepositoryRemoveListener;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.dto.PageDTO;
import com.sillyhat.swing.module.basic.SillyHatInputText;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;
import com.sillyhat.swing.module.container.table.SillyHatPageTable;
import com.sillyhat.swing.utils.StringUtils;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by ${XUSHIKUAN} on 2017-03-12.
 */
public class WordRepositoryList extends SillyHatPageTable {

    private static final long serialVersionUID = 2324535510229650690L;

    private MessageService messageService;

    private WordRepositoryService wordRepositoryService;

    private SillyHatInputText inputText;

    public void initService(){
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        wordRepositoryService = (WordRepositoryService) SpringUtils.getInstance().getContext().getBean(WordRepositoryService.class);
    }

    public WordRepositoryList(String panelCode) {
        super(panelCode);
    }

    @Override
    public JPanel getSearchJPanel() {
        JPanel searchJPanel = new JPanel();
        inputText = new SillyHatInputText(messageService.getMessageZH("word.repository.word"),80, 30, "",20);
        searchJPanel.add(inputText);
        return searchJPanel;
    }

    public int [] getHiddenColumns(){
        int[] intArray = {0};
        return intArray;
    }

    public void clickSearch(){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("WORD",inputText.getTextValue());
        setPageParams(params);
        refreshTable();
    }

    public void tableKeyPressed(KeyEvent e){
        if(e.getKeyChar() == KeyEvent.VK_DELETE){
            String id = "";
            if(getTable().getSelectedRowCount() > 0){
                id = (String)getTable().getValueAt(getTable().getSelectedRow(), 0);
            }
            if(StringUtils.isEmpty(id)){
                SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.reminder.select.data"));
            }else{
                if(SillyHatJOptionPane.confirm(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.reminder.remove")) == SillyHatJOptionPane.OK_OPTION){
                    wordRepositoryService.deleteWordRepository(id);
                    SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.reminder.remove.success"));
                    refreshTable();
                }
            }
        }
    }

    @Override
    public JToolBar getJToolBar() {
        JToolBar operatorBar = new JToolBar();
        JButton btnAdd = new JButton(messageService.getMessageZH("btn.add"));
        JButton btnEdit = new JButton(messageService.getMessageZH("btn.edit"));
        JButton btnRemove = new JButton(messageService.getMessageZH("btn.remove"));
        btnAdd.addActionListener(new WordRepositoryDetailListener(this,false));
        btnEdit.addActionListener(new WordRepositoryDetailListener(this,true));
        btnRemove.addActionListener(new WordRepositoryRemoveListener(this));
        operatorBar.add(btnAdd);
        operatorBar.add(btnEdit);
        operatorBar.add(btnRemove);
        return operatorBar;
    }

    public Vector<String> getColumns() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("");
        columnNames.add(messageService.getMessageZH("word.repository.word"));
        columnNames.add(messageService.getMessageZH("word.repository.us.phonetic"));
        columnNames.add(messageService.getMessageZH("word.repository.uk.phonetic"));
        columnNames.add(messageService.getMessageZH("word.repository.word.translate"));
        columnNames.add(messageService.getMessageZH("word.repository.web.translate"));
        columnNames.add(messageService.getMessageZH("word.repository.sample.sentences"));
        columnNames.add(messageService.getMessageZH("public.label.created.user"));
        columnNames.add(messageService.getMessageZH("public.label.created.date"));
        columnNames.add(messageService.getMessageZH("public.label.updated.user"));
        columnNames.add(messageService.getMessageZH("public.label.updated.date"));
        return columnNames;
    }

    public Vector<Vector<String>> getRowData(PageDTO page) {
        Vector<Vector<String>> rowData = new Vector<Vector<String>>();
        List<WordRepositoryDTO> list = wordRepositoryService.queryWordRepositoryByPage(page);
        for (WordRepositoryDTO dto : list) {
            Vector<String> iColumns = new Vector<String>();
            iColumns.add(dto.getId()+"");
            iColumns.add(dto.getWord());
            iColumns.add(dto.getUsPhonetic());
            iColumns.add(dto.getUkPhonetic());
            iColumns.add(dto.getWordTranslate());
            iColumns.add(dto.getWebTranslate());
            iColumns.add(dto.getSampleSentences());
            iColumns.add(dto.getCreatedUserName());
            iColumns.add(dto.getCreatedDate());
            iColumns.add(dto.getUpdatedUserName());
            iColumns.add(dto.getUpdatedDate());
            rowData.add(iColumns);
        }
        return rowData;
    }

    @Override
    public int getTotalCount(PageDTO page) {
        return wordRepositoryService.queryWordRepositoryTotalCountByPage(page);
    }
}
