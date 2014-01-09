package Opg2;

import java.util.EventListener;

public interface AnswerListener extends EventListener {

	public void Yes(AnswerEvent event);

	public void No(AnswerEvent event);

}
