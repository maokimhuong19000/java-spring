package com.setec.coffee_shop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import lombok.Data;

@Service
@Data

public class MyTelegramBot {
	@Value("${telegram.token}")
	private String token;
	@Value("${chat_id}")
	private long chat_id;

	private TelegramBot bot;

	public SendResponse sendMessage(String message) {
		if (bot == null)
			bot = new TelegramBot(token);
		SendResponse send = bot.execute(new SendMessage(chat_id, message));
		return send;
	}

}
