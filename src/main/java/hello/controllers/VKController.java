package hello.controllers;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.WallPostFull;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class VKController {
    @RequestMapping(path = "/news")
    public String showNews(Model model) throws Exception {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

        ServiceActor user = new ServiceActor(7193860, "tqCMcR6AEVmEfAAeIx3o", "723d3fac723d3fac723d3fac277250faa87723d723d3fac2f83444d86eda24ee779618a");
        GetResponse response = vk.wall().get(user).ownerId(-113376999).execute();
        ArrayList<String> texts = new ArrayList<>();
        for (WallPostFull post : response.getItems()) {
            String text = post.getText();
            String paragraphData[] = text.split("\n");
            String resultText = "";
            for (String paragraph : paragraphData){
                resultText+=(paragraph+"<br>");
            }
            texts.add(resultText);
        }
        model.addAttribute("text", texts);

        return "news";
    }
}

