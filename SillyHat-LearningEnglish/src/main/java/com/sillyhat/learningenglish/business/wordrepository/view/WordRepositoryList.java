package com.sillyhat.learningenglish.business.wordrepository.view;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.listener.DetailWordRepositoryListener;
import com.sillyhat.learningenglish.business.wordrepository.listener.RemoveWordRepositoryListener;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.dto.PageDTO;
import com.sillyhat.swing.module.basic.SillyHatInputText;
import com.sillyhat.swing.module.container.table.SillyHatPageTable;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by ${XUSHIKUAN} on 2017-03-12.
 */
public class WordRepositoryList extends SillyHatPageTable {

    private MessageService messageService;

    private WordRepositoryService wordRepositoryService;

    private SillyHatInputText inputText;
    public void initService(){
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        wordRepositoryService = (WordRepositoryService) SpringUtils.getInstance().getContext().getBean(WordRepositoryService.class);
    }

    public WordRepositoryList(String panelCode,PageDTO page) {
        super(panelCode,page);
        hiddenColumn(0);//隐藏ID列
    }

    @Override
    public JPanel getSearchJPanel() {
        JPanel searchJPanel = new JPanel();
        inputText = new SillyHatInputText(messageService.getMessageZH("word.repository.word"),80, 30, "",20);
        searchJPanel.add(inputText);
        return searchJPanel;
    }

    public void clickSearch(){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("WORD",inputText.getTextValue());
        setPageParams(params);
        refreshTable();
    }

    public void clickUpPage(){

    }

    public void clickHomePage(){

    }

    public void clickNextPage(){

    }

    public void clickLastPage(){

    }

    @Override
    public JToolBar getJToolBar() {
        JToolBar operatorBar = new JToolBar();
        JButton btnAdd = new JButton(messageService.getMessageZH("btn.add"));
        JButton btnEdit = new JButton(messageService.getMessageZH("btn.edit"));
        JButton btnRemove = new JButton(messageService.getMessageZH("btn.remove"));
        btnAdd.addActionListener(new DetailWordRepositoryListener(this.getTable(),false));
        btnEdit.addActionListener(new DetailWordRepositoryListener(this.getTable(),true));
        btnRemove.addActionListener(new RemoveWordRepositoryListener(this.getTable()));
        operatorBar.add(btnAdd);
        operatorBar.add(btnEdit);
        operatorBar.add(btnRemove);
        return operatorBar;
    }

    public Vector<String> getColumns() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("--");
        columnNames.add(messageService.getMessageZH("word.repository.word"));
        columnNames.add(messageService.getMessageZH("word.repository.phonetic"));
        columnNames.add(messageService.getMessageZH("word.repository.reminder"));
        columnNames.add(messageService.getMessageZH("word.repository.word.translate"));
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
            iColumns.add(dto.getId());
            iColumns.add(dto.getWord());
            iColumns.add(dto.getPhonetic());
            iColumns.add(dto.getReminder());
            iColumns.add(dto.getWordTranslate());
            iColumns.add(dto.getCreatedUser());
            iColumns.add(dto.getCreatedDate());
            iColumns.add(dto.getUpdatedUser());
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
