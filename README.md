##Notes

-Used apache.common library to generate random names. 

- Still on todo: 4) If you have time. Add a response header to the REST service that will solve the same origin policy 
problem, so client pages hosted on other servers can access the service. 

##General part

>Explain the term REST and the architectural Requirements that relates to REST 
insert text here!


>Elaborate on how JSON or XML supports communication between subsystems, even when the subsystems are implemented on different platforms.
Not sure if I understand the full extent of this question...

When one chooese a shared/uniform data-protocol such as json or xml you then only expose that json-data and nothing else. They subsystems does not care from which platform is has received the json or where it will send it, as long as the json-data are correctly formatted. 