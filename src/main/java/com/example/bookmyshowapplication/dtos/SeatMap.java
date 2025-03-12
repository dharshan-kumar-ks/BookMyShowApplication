package com.example.bookmyshowapplication.dtos;

import com.example.bookmyshowapplication.models.ShowSeat;
import lombok.Data;
import org.springframework.data.util.Pair;
import java.util.List;

@Data
// SeatMap -> List of Pair<seat_row, seat_column>
public class SeatMap {
    // Pair -> used when you need to associate two values together without creating a separate class for them.
    List<Pair<Integer, Integer>> seats; // Pair(row of seat, column of seat)

    // SeatMap(List of Shows) -> Given the List of Seats as input; return the List of Pair<seat_row, seat_column> as output
    public SeatMap(List<ShowSeat> showSeats) {
        for(ShowSeat showSeat : showSeats) {
            seats.add(Pair.of(showSeat.getSeat().getRow(), showSeat.getSeat().getCol()));
        }
    }
}
