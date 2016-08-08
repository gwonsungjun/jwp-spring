package main;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import next.model.User;
import next.service.QnaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by jojoldu@gmail.com on 2016-08-08.
 */
@RunWith(MockitoJUnitRunner.class)
public class QnaServiceTest {

    @Mock
    private QuestionDao questionDao;

    @Mock
    private AnswerDao answerDao;

    @InjectMocks
    private QnaService qnaService;

    @Before
    public void setup() throws Exception{
        when(questionDao.findById(0)).thenReturn(new Question("jojoldu", "title", "contents"));
        when(answerDao.findAllByQuestionId(0)).thenReturn(new ArrayList<>());
    }

    @Test
    public void test_질문삭제와답변0() throws Exception {
        assertThat(qnaService.deleteQuestion(0, new User("jojoldu", "1234", "name", "jojoldu@gmail.com")), is(false));
    }

    @Test
    public void test_질문삭제와답변1() throws Exception {
        assertThat(qnaService.deleteQuestion(0, new User("jojoldu", "1234", "name", "jojoldu@gmail.com")), is(false));
    }

}
