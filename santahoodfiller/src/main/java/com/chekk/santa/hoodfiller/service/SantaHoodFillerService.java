package com.chekk.santa.hoodfiller.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SantaHoodFillerService {
	
	
	public  List<Integer> minimumPresents(int[] givenWeights, int hoodCapacity)
    {
        // Array to hold the index of weights
        int[] selectedWeightsIndex = new int[hoodCapacity + 1];
        // Array to hold total ways to reach specific sum
        int[] count = new int[hoodCapacity + 1];

        count[0] = 1;
        for (int i = 0 ; i < hoodCapacity; i++){
            if (count[i] > 0){
                for (int j = 0; j < givenWeights.length; j++)
                {
                    int k = i + givenWeights[j];
                    if (k <= hoodCapacity)
                    {
                        if (count[k] == 0 || count[k] > count[i] + 1)
                        {
                            count[k] = count[i] + 1;
                            selectedWeightsIndex[k] = j;
                        }
                    }
                }
            }
        }
        // No result
        if (count[hoodCapacity] == 0)
            return null;

        // The final array representing the weights of presents
        int[] minimumPresents = new int[count[hoodCapacity] - 1];
        int temp = hoodCapacity;
        while (temp > 0)
        {
            minimumPresents[count[temp] - 2] = givenWeights[selectedWeightsIndex[temp]];
            temp = temp - givenWeights[selectedWeightsIndex[temp]];
        }

        List<Integer> result = Arrays.stream(minimumPresents).boxed().collect(Collectors.toList()); 
        return result;
    }

}
