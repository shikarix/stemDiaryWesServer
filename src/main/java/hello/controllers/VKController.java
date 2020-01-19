package hello.controllers;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.WallPostFull;
import com.vk.api.sdk.objects.wall.WallpostAttachment;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import hello.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class VKController {
    @RequestMapping(path = "/news")
    public String showNews(Model model) throws Exception {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

        ServiceActor user = new ServiceActor(7193860, "tqCMcR6AEVmEfAAeIx3o", "723d3fac723d3fac723d3fac277250faa87723d723d3fac2f83444d86eda24ee779618a");
        GetResponse response = vk.wall().get(user).ownerId(-113376999).execute();
        ArrayList<Post> posts = new ArrayList<>();
        for (WallPostFull post : response.getItems()) {
            String text = post.getText();
            Post newPost = new Post();
            if (post.getAttachments() != null)
                for (WallpostAttachment attachment : post.getAttachments()) {
                    if (attachment.getPhoto() != null) {
                        newPost.setSrcToImage(attachment.getPhoto().getPhoto130());
                    } else {
                        if (attachment.getVideo() != null) {
                            newPost.setSrcToImage(attachment.getVideo().getPhoto130());
                        } else
                            newPost.setSrcToImage("https://static.tildacdn.com/tild3865-3431-4934-a462-636139616135/noroot.png");

                    }
                }
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 'я') {
                    chars[i] = 0;
                }
            }
            text = "";
            for (int i = 0; i < chars.length; i++) {
                text += chars[i];
            }
            if (text.equals("")){
                continue;
            }
            String paragraphData[] = text.split("\n");
            String resultText = "";
            for (String paragraph : paragraphData) {
                resultText += (paragraph + "<br>");
            }
            String words[] = text.split(" ");
            String preview = "";
            for (int i = 0; i < (words.length > 50 ? 50 : words.length); i++) {
                preview += (words[i] + " ");
            }
            preview += words.length > 10 ? "...<br> <a href=\"https://vk.com/coistem?w=wall-113376999_" + post.getId() + "\" style=\"color:black;\">Подробнее</a>" : "";
            newPost.setText(preview);
            posts.add(newPost);
        }
        model.addAttribute("posts", posts);

        return "news";
    }
}

