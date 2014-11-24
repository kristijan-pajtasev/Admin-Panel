package com.kristijan.pajtasev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.kristijan.pajtasev.model.LocalFolder;

/**
 * Created by kristijan on 05.11.14..
 */
@Controller
public class MainController {

    @RequestMapping(value = "/content", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<LocalFolder>> content(HttpServletRequest request, @RequestBody String path) {


        File[] files = getFiles(path);

        List<LocalFolder> rootNames = new ArrayList<LocalFolder>();

        if(!path.isEmpty()) {
            File parentFile = new File(path).getParentFile();
            if(parentFile != null) {
                LocalFolder localFolder = new LocalFolder(parentFile);
                localFolder.setName("../");
                rootNames.add(localFolder);
            }
        }

        if(files != null) {
            for (File f : files) {
                rootNames.add(new LocalFolder(f));
            }
        }

        return new ResponseEntity<List<LocalFolder>>(rootNames, HttpStatus.OK);
    }

    @RequestMapping(value = "/")
    public String indexTemplate(Model model) {
        return "index";
    }

    private File[] getFiles(String path) {
        File[] files;
        if(path.isEmpty()) {
            files = (new File(path)).listRoots();
        } else {
            files = (new File(path)).listFiles();
        }
        return files;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginTemplate(Model model) {
        return "login";
    }



}
