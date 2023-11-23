package com.fandomhub.mongoangular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fandomhub.mongoangular.model.Forums;
import com.fandomhub.mongoangular.model.User;
import com.fandomhub.mongoangular.model.lastid;
import com.fandomhub.mongoangular.repository.ForumsRepository;
import com.fandomhub.mongoangular.repository.LastIdRepository;
import com.fandomhub.mongoangular.resources.FeedController;
import com.fandomhub.mongoangular.resources.LastIdController;


//@RunWith(SpringRunner.class)
//@SpringBootTest
class MongoangularApplicationTests {
	

}
