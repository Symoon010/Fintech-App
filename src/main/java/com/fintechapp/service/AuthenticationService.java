package com.fintechapp.service;

import com.fintechapp.model.dto.authentication.AuthenticationRequestDto;
import com.fintechapp.model.dto.authentication.AuthenticationResponseDto;
import com.fintechapp.model.dto.public_token.SignUpDetailsDto;
import com.fintechapp.model.entity.SignInDetailsEntity;
import com.fintechapp.model.entity.SignUpDetailsEntity;
import com.fintechapp.repository.SignInDetailsRepository;
import com.fintechapp.repository.UserRepository;
import com.fintechapp.security.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SignInDetailsRepository signInDetailsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    DateTimeService dateTimeService;


    public void saveUserInformation(){
        // userRepository.save()
    }


    public ResponseEntity<?> saveUserDetails(SignUpDetailsDto userDetails) {

        SignUpDetailsEntity signUpDetailsEntity = new SignUpDetailsEntity();
        if(userRepository.existsByEmail(userDetails.getUserEmail())){
            return new ResponseEntity<>("Email Address already in use!", HttpStatus.BAD_REQUEST);
        }

        //Creating new user account

        signUpDetailsEntity  = modelMapper.map(userDetails,SignUpDetailsEntity.class);

        try{
            userRepository.save(signUpDetailsEntity);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Failed to save user Information", HttpStatus.BAD_REQUEST);
        }
        return new  ResponseEntity<>("Successfully save user Information", HttpStatus.OK);

    }

    public ResponseEntity<?> checkAuthentication(AuthenticationRequestDto authenticationRequestDto) throws Exception {

        SignInDetailsEntity  signInDetailsEntity = new SignInDetailsEntity();


        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(),authenticationRequestDto.getPassword()));
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username and password",e);
        }


        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestDto.getUsername());
        final  String  jwt = jwtUtil.generateToken(userDetails);

        signInDetailsEntity.setJwtToken(jwt);
        signInDetailsEntity.setName(authenticationRequestDto.getUsername());
        signInDetailsEntity.setEntryTime(dateTimeService.getCurrentTime());
        signInDetailsRepository.save(signInDetailsEntity);
        return  ResponseEntity.ok(new AuthenticationResponseDto(jwt));
    }
}
