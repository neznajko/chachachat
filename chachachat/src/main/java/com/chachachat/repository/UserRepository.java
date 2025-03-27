////////////////////////////////////////////////////////////////
package com.chachachat.repository;
////////////////////////////////////////////////////////////////
import org.springframework.data.repository.CrudRepository;
////////////////////////////////////////////////////////////////
import java.util.Optional;
////////////////////////////////////////////////////////////////
import com.chachachat.model.User;
////////////////////////////////////////////////////////////////
public interface UserRepository
    extends CrudRepository <User,Long> {
    
    Optional <User> findByName( String name );
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 1. My bicycle was 30,000 yen.
//    じてんしゃは３万円でした。
// 2. Yesterday was Sunday.
//    きのうは日曜日でした。
// 3. Professor Yamashita was not a Nihon University student.
//    山下先生は日本大学の学生じゃなかったです。
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 2.1.23: A body of mass m lying on a horizontal plane is
// subject to a force F at an angle a to the horizontal. The
// coefficient of friction is _. Find the acceleration of the
// body if it does not break away from the plane.
//
//
//                   A Fsina
//                   | 
//                   A N
//                   |
//                 __|__
//        _N <----|     |-----> Fcosa
// ==================|==========================================
//                   |
//                   |
//                   V mg
//
// Fsina + N = mg, N = mg - Fsina
// Fcosa - _N = Fcosa - _(mg - Fsina) = F(cosa + _sina ) - _mg =
//            = ma, so
// a = (F/m)(cosa + _sina ) - _g                               «
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 31. Elk dwell in a certain forest. There are N elk, of which
// a simple random sample of size n are captured and tagged
// (“simple random sample” means that all C(N,n) sets of n elk
// are equally likely). The captured elk are returned to the
// population, and then a new sample is drawn, this time with
// size m. This is an important method that is widely used in
// ecology, known as capture-recapture. What is the probability
// that exactly k of the m elk in the new sample were previously
// tagged? (Assume that an elk that was captured before doesn’t
// become more or less likely to be captured again.)
//
// Sooo, let's number all elks from 1 to N, then an elementary
// event is an ordered tuple: (a[1],a[2],...,a[m]), for example
// if N = 20, m = 5 one event is (7, 8, 13, 14, 20). There are
// totally C(N, m) such tuples. Let tagged elks are marked with
// asterisk like (7, 8*, 10, 14*, 20), here k = 2, then we can
// separate the tuple as (8*, 14*)(7, 10, 20), so the number of
// all positive events is C(n, k)C(N - n, m - k), and the
// desired probability is: P = C(n, k)C(N - n, m - k)/C(N, m)
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
