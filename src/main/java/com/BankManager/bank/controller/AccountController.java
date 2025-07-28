package com.BankManager.bank.controller;

import com.BankManager.bank.model.User;
import com.BankManager.bank.dto.UpdateBalance;
import com.BankManager.bank.dto.FundTransfer; 
import com.BankManager.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired // Begins the dependancy injection 
    private UserRepository userRepository;

    @PostMapping("/signUp") // When a post request is sent on this endpoint, the method below is then executed
    public String signUp(@RequestBody User user) { // The parameter reads the json data and serializes it into an object
        userRepository.save(user); 
        return "User registered: " + user.getUserName();
    }

    @PostMapping("/updateBalance")
    public String updateBalance(@RequestBody UpdateBalance request){
        //Create the object of the user from the user repository. 
        Optional<User> optionalUser = userRepository.findById(request.getId());

        if(optionalUser.isEmpty()){
            return "Unknown User";
        }

        User user = optionalUser.get();
        double newBalance = user.getBalance() + request.getAmount();

        user.setBalance(newBalance);
        userRepository.save(user);

        return "New user balance is " + newBalance;
    }

    @PostMapping("/fundTransfer") //
    public String fundTransfer(@RequestBody FundTransfer request){
        Optional<User> sender = userRepository.findById(request.getSender());
        Optional<User> recipiant = userRepository.findById(request.getRecipiant());

        //If the users arent inside the database, return a fail message
        if(sender.isEmpty()){
            return "Sender ID Unknown.";
        } 

        if(recipiant.isEmpty()){
            return "Recipiant ID Unknown";
        }

        //Check the balance of the sender if its greater than the amount being sent
        User senderInfo = sender.get();
        double senderBalance = senderInfo.getBalance();
        
        //Get the amount that is being sent 
        double sentAmount = request.getAmount();

        if(senderBalance < sentAmount){
            return "Insufficient funds.";
        }

        //Updated values after the operations
        
        User recipiantInfo = recipiant.get();
        double updatedRecipiantBalance = recipiantInfo.getBalance() + sentAmount; 
        double updatedSenderBalance = senderInfo.getBalance() - sentAmount; 

        //Update the actual balances
        senderInfo.setBalance(updatedSenderBalance);
        recipiantInfo.setBalance(updatedRecipiantBalance);

        userRepository.save(senderInfo);
        userRepository.save(recipiantInfo);

        return "Transaction successful.";
    }

    @GetMapping("/demo")
    public String demo(@RequestParam String name) {
        return name;
    }
}
