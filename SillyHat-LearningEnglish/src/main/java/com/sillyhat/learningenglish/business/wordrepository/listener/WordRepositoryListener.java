package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.dto.PageDTO;
import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.business.wordrepository.view.WordRepositoryList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 题库录入页面
 */
public class WordRepositoryListener implements ActionListener{

	private SillyHatTabModulePanel modulePanel;

	private MessageService messageService;
	
	public WordRepositoryListener(SillyHatTabModulePanel modulePanel){
		messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
		this.modulePanel = modulePanel;
	}

	public void actionPerformed(ActionEvent e) {
		WordRepositoryList wordRepositoryList = new WordRepositoryList(Constants.PANEL_CODE_WORD_REPOSITORY);
		wordRepositoryList.initTable(new PageDTO());
		wordRepositoryList.hiddenColumn(0);
		wordRepositoryList.refreshTable();;
		modulePanel.addTabPanel(messageService.getMessageZH("menu.word.repository"),wordRepositoryList);
	}

}
