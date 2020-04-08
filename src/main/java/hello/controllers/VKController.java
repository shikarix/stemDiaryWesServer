package hello.controllers;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.WallPostFull;
import com.vk.api.sdk.objects.wall.WallpostAttachment;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import hello.domain.Post;
import hello.repos.PupilReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller
public class VKController {
    @Autowired
    PupilReposutory pupilRepository;
    @RequestMapping(path = "/news")
    public String showNews(Model model) throws Exception {
        model.addAttribute("is", pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).isThisAdmin());
        model.addAttribute("color", pupilRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).getColorTheme());
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
                        newPost.setSrcToImage(attachment.getPhoto().getPhoto807());
                    } else {
                        if (attachment.getVideo() != null) {
                            newPost.setSrcToImage(attachment.getVideo().getPhoto800());
                        } else
                            newPost.setSrcToImage("https://sun9-42.userapi.com/c840639/v840639776/6f0b8/_yfExCc5uf8.jpg");

                    }
                }
            else{
                newPost.setSrcToImage("https://sun9-42.userapi.com/c840639/v840639776/6f0b8/_yfExCc5uf8.jpg");
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
            for (int i = 0; i < (Math.min(words.length, 50)); i++) {
                preview += (words[i] + " ");
            }
            preview += "...<br> <a href=\"https://vk.com/coistem?w=wall-113376999_" + post.getId() + "\" style=\"color:black;\">Подробнее</a>";
            newPost.setText(preview);

            long time = post.getDate();
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(time * 1000L);
            System.out.println(formattedDate);

            newPost.setDate(formattedDate);
            posts.add(newPost);


        }
        model.addAttribute("posts", posts);

        return "news";
    }
}

