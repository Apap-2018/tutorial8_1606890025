1. Apa fungsi BCryptPasswordEncoder?
        BCrypt digunakan untuk melakukan encoding pada password agar sistem tidak menyimpan password secara raw/plaintext begitu saja.

2. - Apa yang dilakukan baris berikut?
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

        grantedAuthorities membuat set dari otoritas dari user. pada tutorial8, otoritas dibagi berdasarkan rolenya. hal ini diatur dalam WebSecurityConfig.java

                http
                        .authorizeRequests()
                        .antMatchers("/css/**").permitAll()
                        .antMatchers("/js/**").permitAll()
                        .antMatchers("/user/addUser").permitAll()
                        .antMatchers("/flight/**").hasAnyAuthority("PILOT")
                        .antMatchers("/pilot/**").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated()
        
        set tersebut akan dilanjutkan ke class User untuk dicek ketika sistem mendapat request dari user yang mengirim request tersebut

