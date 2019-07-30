package petClinics;

import java.util.Iterator;

public class Clinic implements Iterable<Pet>{
    private String name;
    private Pet[] rooms;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.setRoom(rooms);
    }

    private void setRoom(int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[rooms];
    }

    public boolean add(Pet pet) {
        int room = this.rooms.length / 2;

        for (int i = 0; i < this.rooms.length; i++) {
            if (i % 2 != 0) {
                room -= i;
            } else {
                room += i;
            }

            if (this.rooms[room] == null) {
                this.rooms[room] = pet;
                return true;
            }
        }
        return false;
    }


    public boolean release() {
        int midRoom = this.rooms.length / 2;

        for (int i = midRoom; i < this.rooms.length; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }

        for (int i = 0; i < midRoom; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet room : rooms) {
            if (room == null) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < rooms.length;
            }

            @Override
            public Pet next() {
                return rooms[this.index++];
            }
        };
    }

    public String printRoom(int index) {
        if (this.rooms[index] == null) {
            return "Room empty";
        }

        return this.rooms[index].toString();
    }
}
