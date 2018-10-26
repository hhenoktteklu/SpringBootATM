package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("account", accountRepository.findAll());
        return "homepage";
    }

    @RequestMapping("/deposit/{id}")
    public String deposit(Model model, @PathVariable long id){
        model.addAttribute("account", accountRepository.findById(id));
        return "deposit";
    }


    @RequestMapping("/processdeposit")
    public String processDeposit(Account account, Model model){
        System.out.println("Before: "+account.getBalance());
        account.setBalance(account.getBalance()+account.getAmount());
        System.out.println("After: "+account.getBalance());
        return "homepage";
    }

    @RequestMapping("processwithdraw")
    public String processWithdraw(Account account){
        return "homepage";
    }

    @RequestMapping("/withdraw/{id}")
    public String withdraw(Model model,@PathVariable long id){
        model.addAttribute("account", accountRepository.findById(id));
        return "withdraw";
    }

    @RequestMapping("/transaction/{id}")
    public String transaction(Model model, @PathVariable long id){
        model.addAttribute("account", accountRepository.findById(id));
        return "transaction";
    }

    @RequestMapping("/createaccount")
    public String createAccount(Model model){
        model.addAttribute("account", new Account());
        return "createaccount";
    }

    @RequestMapping("/createaccountprocess")
    public String createAccountProcess(Account account){
        System.out.println(account);
        accountRepository.save(account);
        return "redirect:/";
    }
}
