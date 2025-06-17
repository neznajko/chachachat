////////////////////////////////////////////////////////////////
package com.chachachat.controller;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
////////////////////////////////////////////////////////////////
import com.chachachat.service.UserService;
import com.chachachat.model.User;
////////////////////////////////////////////////////////////////
import java.util.List;
////////////////////////////////////////////////////////////////
@RestController
@RequestMapping( "/api/users" )
public class UserRestController {
    
    private final UserService userService;
    
    public UserRestController( UserService userService ){
        this.userService = userService;
    }
    @GetMapping
    public List <User> getAllUsers() {
        return userService.findAll();
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 2.1.39*. The drag force of a liquid or g a s, proportional to 
// the square of the velocity of a moving b o d y, is associated 
// with the formation of vortices in the medium near the surface
// of this body. The drag force, proportional to the velocity of
// a moving body, is associated with t h e slippage of layers of
// the medium as it flows around this body. Both phenomena occur
// simultaneously. W h y, nevertheless, under certain conditions,
// can only one type o f resistance be taken into account? Based
// o n the data from the two previous problems, estimate at what
// value of the product of the radius of a r o u n d drop by its
// velocity both types of air resistance are comparable in their
// effect on the movement of the drop.
//
// In previous problems we have looked at t h e resistance force
// from air acting on a raindrop which was equal t o f = Aρ₀r²v²,
// A ~ 1, ρ₀ = 1.3 kg/m³ - density of the air, r and v a r e the
// radius and the velocity of the raindrop. If the same raindrop
// is falling in fog the force is γrv, such that when the radius
// is 0.1mm t h e maximum velocity w i l l be 1m/s. When the two
// forces a r e similar we'll have Aρ₀r²v² = γrv, and rv = γ/Aρ₀,
// so w e have to find the v a l u e of γ. Now t h e first force
// occures w h e n the fluid has turbulent motion and the second
// when the fluid moves i n layers a l s o called laminar motion,
// so both seems incompatible we can't have turbulent and steady
// flow at the same t i m e, although the transition mode can be
// s e e n in the smoke of a cigarette initially it goes laminar
// and t h e n turbulent, funny enough in Bulgarian there is one
// word: ламарина[ lamarina ] meaning sheet m e t a l, which has
// same origin as laminar flow both a r e comming from the latin
// w o r d lamina( thin plate/layer ). When raindrop reaches its
// maximum v    e    l    o    c    i    t    y we'll h  a  v  e:
// mg = γrv = ρ(4/3)πr³g, and γ = 4ρgπr²/3v w h e r e ρ is t h e
// density of the water, so n o w we have to s u b s t i t u t e:
// ρ = 1000 kg/m³
// g = 9.8 m/s²
// π = 3.1415
// r = 10⁻⁴ m
// v = 1 m/s
// γ = 4.1029 10⁻⁴ kg/ms, so both forces will be compatible when
// rv = γ/Aρ₀ = 3.2 10⁻⁴ m²/s                                  «
////////////////////////////////////////////////////////////////
// 17. Suppose (a,b) = 1. If a|c and b|c prove that ab|c
// #############################################################
// From a|c, c = as, s o b|as and (a,b) = 1, f r o m Theorem 1.4
// b|s, s o s = bt and c = abt. There is also another prove that
// d o e s n ' t use the Theorem 1.4; From (a,b) = 1 w e h a v e:
// au + bv = 1, for some integers u a n d v and from a|c and b|c
// w e have c = as, c = bt. L e t ' s multiply au + bv = 1 by st:
// astu + bstv = st = ctu + csv = c( tu + sv ), c² = asbt = abst,
// so st = c²/ab = c(tu + sv), so c = ab(tu + sv)              «
// #############################################################
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
