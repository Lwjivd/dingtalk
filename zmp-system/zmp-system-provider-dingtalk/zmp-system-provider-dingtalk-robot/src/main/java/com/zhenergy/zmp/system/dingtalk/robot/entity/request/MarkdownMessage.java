package com.zhenergy.zmp.system.dingtalk.robot.entity.request;

public class MarkdownMessage extends Message {

	private String msgtype="markdown";
	private Markdown markdown;
	private At at;

	public MarkdownMessage(String title,String text,String[] atMobiles){
		this.markdown=new Markdown(title,text);
		this.at=new At(atMobiles);
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Markdown getMarkdown() {
		return markdown;
	}

	public void setMarkdown(Markdown markdown) {
		this.markdown = markdown;
	}

	public At getAt() {
		return at;
	}

	public void setAt(At at) {
		this.at = at;
	}

}