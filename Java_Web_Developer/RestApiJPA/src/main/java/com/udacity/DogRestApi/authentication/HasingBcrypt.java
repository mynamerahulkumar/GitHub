package com.udacity.DogRestApi.authentication;

public class HasingBcrypt {

  // / To encode a given rawPassword
//    public String encode(CharSequence rawPassword) {
//        if (rawPassword == null) {
//            throw new IllegalArgumentException("rawPassword cannot be null");
//        } else {
//            String salt;
//            if (this.random != null) {
//                salt = BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
//            } else {
//                salt = BCrypt.gensalt(this.version.getVersion(), this.strength);
//            }
//
//            return BCrypt.hashpw(rawPassword.toString(), salt);
//        }
//    }
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        if (rawPassword == null) {
//            throw new IllegalArgumentException("rawPassword cannot be null");
//        } else if (encodedPassword != null && encodedPassword.length() != 0) {
//            if (!this.BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
//                this.logger.warn("Encoded password does not look like BCrypt");
//                return false;
//            } else {
//                return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
//            }
//        } else {
//            this.logger.warn("Empty encoded password");
//            return false;
//        }
//    }
//    public boolean upgradeEncoding(String encodedPassword) {
//        if (encodedPassword != null && encodedPassword.length() != 0) {
//            Matcher matcher = this.BCRYPT_PATTERN.matcher(encodedPassword);
//            if (!matcher.matches()) {
//                throw new IllegalArgumentException("Encoded password does not look like BCrypt: " + encodedPassword);
//            } else {
//                int strength = Integer.parseInt(matcher.group(2));
//                return strength < this.strength;
//            }
//        } else {
//            this.logger.warn("Empty encoded password");
//            return false;
//        }
//    }
}
